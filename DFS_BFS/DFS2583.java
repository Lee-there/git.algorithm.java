import java.util.*;

public class DFS2583 {
    static int n,m;
    static int ans;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public void DFS(int x , int y){
        ans++;
        board[x][y] = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                DFS(nx,ny);
            }
        }
    }    
    public void solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0){
                    ans = 0;
                    DFS(i,j);
                    result.add(ans);
                }
            }
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        DFS2583 T = new DFS2583();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        int A = in.nextInt();
        for (int i = 0; i < A; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            for (int r = y1; r < y2; r++) {
                Arrays.fill(board[r], x1, x2, 1);
            }
        }
        T.solution();
        Collections.sort(result);
        System.out.println(result.size());
        for(int x : result) System.out.print(x + " ");
        in.close();
    }
}
/* 개선 1. 만약 DFS를 int형 함수로 바꾸면 좀 떠 깔끔한 코드 가능 (DFS 부분 잘 보고 복습하기) 
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // int를 반환하여 탐색한 영역의 넓이를 직접 가져옴
    public int DFS(int x, int y) {
        board[x][y] = 1; // 방문 처리
        int count = 1;   // 현재 자기 자신의 칸(넓이 1)

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                // 자식 DFS들이 세어온 넓이를 내 count에 누적
                count += DFS(nx, ny);   // 이 부분이 제일 중요 (이해 안되면 밑 참고)
            }
        }
        return count; // 최종 합산된 넓이를 반환
    }
    public void solution() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    // DFS가 반환한 넓이를 바로 리스트에 추가
                    result.add(DFS(i, j)); //내 코드보다 좀 더 간결(변수 적음)
                }
            }
        }
        // 결과 정렬 및 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        board = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            
            // 직사각형 칠하기 (r: 행, c: 열)
            for (int r = y1; r < y2; r++) {
                Arrays.fill(board[r], x1, x2, 1);
            }
        }
        T.solution();
        in.close();
    }
}


 if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                // 자식 DFS들이 세어온 넓이를 내 count에 누적
                count += DFS(nx, ny);   
            } 

***count += DFS(nx, ny); 이해 안될 시 읽어보기***
상황극: 동굴 탐사 (DFS)
당신은 팀장이고, 동굴이 얼마나 넓은지(칸수) 알아오려고 합니다.

팀장(첫 DFS): "나는 일단 1칸(현재 칸) 확보! 이제 옆길로 대원 한 명 보낸다."

대원 A(재귀 호출): "팀장님, 제가 가보니까 제 구역 포함해서 총 5칸이 더 있네요! (리턴 값: 5)"

팀장: "오 그래? 그럼 아까 내가 센 1칸에 네가 보고한 5칸 더해서 총 6칸이군! (count += 5)"

팀장: "이번엔 뒷길로도 대원 한 명 보낸다."

대원 B(재귀 호출): "팀장님, 여기는 막다른 길이라 저밖에 없어요. 1칸입니다! (리턴 값: 1)"

팀장: "오케이, 그럼 아까 계산한 6칸에 이번에 보고받은 1칸 더해서 총 7칸! (count += 1)"

팀장: "이제 더 갈 데 없나? 오케이, 본부에 총 7칸이라고 보고하자! (return count)"
*/

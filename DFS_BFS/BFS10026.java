import java.util.*;

public class BFS10026 {
    static char[][] board;
    static int[][] ch;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    public void BFSP(int x, int y){
        
        ch[x][y] = 1;
        char k = board[x][y];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x*n+y);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int a=0; a<4; a++){
                int nx = tmp/n + dx[a];
                int ny = tmp%n + dy[a];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == k && ch[nx][ny] == 0){
                    Q.offer(nx*n+ny);
                    ch[nx][ny] = 1;
                }
            }
        }
    }
    public int solutionP(){
        for(int i=0; i<n; i++){
            Arrays.fill(ch[i],0);
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ch[i][j] == 0){
                    BFSP(i,j);
                    answer++;
                }
            }
        }
        return answer;
    }
    public void BFSF(int x, int y){
        char[][] Nboard = board.clone();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(Nboard[i][j] == 'G'){
                    Nboard[i][j] = 'R';
                }
            }
        }
        ch[x][y] = 1;
        char k = Nboard[x][y];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x*n+y);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int a=0; a<4; a++){
                int nx = tmp/n + dx[a];
                int ny = tmp%n + dy[a];
                if(nx>=0 && nx<n && ny>=0 && ny<n && Nboard[nx][ny] == k && ch[nx][ny] == 0){
                    Q.offer(nx*n+ny);
                    ch[nx][ny] = 1;
                }
            }
        }
    }
    public int solutionF(){
        for(int i=0; i<n; i++){
            Arrays.fill(ch[i],0);
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ch[i][j] == 0){
                    BFSF(i,j);
                    answer++;
                }
            }
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS10026 T = new BFS10026();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new char[n][n];
        ch = new int[n][n];
        for(int i=0; i<n; i++){
            String a = in.next();
            for(int j=0; j<n; j++){
                board[i][j] = a.charAt(j);
            }
        }
        System.out.println(T.solutionP() + " " + T.solutionF());
        in.close();
    }
}
/* Gemini가 짜준 개선된 코드 보면서 복습하기
개선1. 밑 코드는 board함수로 먼저 일반인 기준 출력 후 board를 색맹용으로 바꿔주어 다시 출력(BFS단일화)
개선2. board[i] = in.next().toCharArray(); 을 통한 입력받을 때 효율성 증가
팁1. 밑 코드는 가독성을 위해 x*n+y사용하는 대신 int[] {x,y}사용함 (내 코드가 속도 면에서는 더 좋음)
import java.util.*;

public class BFS10026_Improved {
    static char[][] board;
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    // BFS를 하나로 통합 (전달받은 판판에서 탐색 수행)
    public void BFS(int x, int y) {
        ch[x][y] = 1;
        char targetColor = board[x][y];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});

        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            for (int a = 0; a < 4; a++) {
                int nx = tmp[0] + dx[a];
                int ny = tmp[1] + dy[a];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (board[nx][ny] == targetColor && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public int getAreaCount() {
        // 호출될 때마다 방문 배열 초기화
        for (int i = 0; i < n; i++) Arrays.fill(ch[i], 0);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0) {
                    BFS(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BFS10026_Improved T = new BFS10026_Improved();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new char[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = in.next().toCharArray(); // 한 줄로 입력 처리
        }

        // 1. 일반인 기준 결과 출력
        System.out.print(T.getAreaCount() + " ");

        // 2. 적록색약 모드로 데이터 변환 (G를 R로 변경)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') board[i][j] = 'R';
            }
        }

        // 3. 적록색약 기준 결과 출력
        System.out.println(T.getAreaCount());
        in.close();
    }
} */
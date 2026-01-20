import java.util.*;

public class BFS2583 {
    static int n,m;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public void BFS(int x , int y){
        int answer = 1;
        board[x][y] = 1;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x,y});
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    Q.offer(new int[] {nx,ny});
                    answer++;
                }
            }
        }
        ans.add(answer);
    }
    public void solution(){
        int z = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0){
                    z++;
                    BFS(i,j);
                }
            }
        }
        System.out.println(z);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS2583 T = new BFS2583();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        int A = in.nextInt();
        for(int i=0; i<A; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            for(int k = b; k<d; k++){
                for(int j = a; j<c; j++){
                    board[k][j] = 1;
                }
            }
        }
        T.solution();
        Collections.sort(ans);
        for(int x : ans) System.out.print(x + " ");
        in.close();
    }
}
/*
개선1 answer = 0으로 설정하고 answer++ 타이밍을 Q.poll하는 시점으로 하는게 더 깔끔한 코드
개선2 BFS자체에서 넓이값을 return하도록 하고 그 값을 Main 함수의 result 리스트를 하나 만들어 넣었다면
      solution함수가 필요 없었을듯 함
개선3 정말로 입력받는 부분에서 최적화를 한다면 이렇게도 표현할 수 있음
      -> 
for (int i = 0; i < A; i++) {
    int x1 = in.nextInt();
    int y1 = in.nextInt();
    int x2 = in.nextInt();
    int y2 = in.nextInt();
    // y좌표(세로)를 행(r), x좌표(가로)를 열(c)로 매칭
    for (int r = y1; r < y2; r++) {
        // 안쪽 for문 대신 Arrays.fill 사용
        // board[r]이라는 행 배열의 x1 인덱스부터 x2-1 인덱스까지 1로 채움
        Arrays.fill(board[r], x1, x2, 1);
    }
}  */

import java.util.*;

class BFS2178{
    static int n,m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    static int[][] dis;
    public int BFS(int x , int y){
        dis[x][y] = 1;
        board[x][y] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x*m+y);
        while(!Q.isEmpty()){
            int tem = Q.poll();
            if(tem/m == n-1 && tem%m == m-1) return dis[tem/m][tem%m];
            for(int i=0; i<4; i++){
                int nx = tem/m + dx[i];
                int ny = tem%m + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    dis[nx][ny] = dis[tem/m][tem%m] +1;
                    Q.offer(nx*m+ny);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        BFS2178 T = new BFS2178();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for(int i=0; i<n; i++){
            String tmp = in.next();
            for(int j=0; j<m; j++){
                board[i][j] = tmp.charAt(j) - '0';
            }
        }
        System.out.println(T.BFS(0,0));
        in.close();
    }
}
/* 처음 풀 떄 dis배열을 만들어 dis[nx][ny] = dis[tem/m][tem%m] +1; 이 방식을 통해 문제 해답
구하는 것이 기억이 안났음 ( 전에 푼 것 중에 비슷한 문제가 있었다는 기억이 있어 예전 코드 확인해봄)
-> 복습 잘해서 내걸로 완전히 만들자
 */
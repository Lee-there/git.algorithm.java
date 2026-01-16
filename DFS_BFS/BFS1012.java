import java.util.*;

class BFS1012{
    static Queue<Integer> Q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public void BFS(int x , int y, int n, int m, int[][] arr){
        Q.clear();
        arr[x][y] = 0;
        Q.offer(x*m+y);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp/m + dx[i];
                int ny = tmp%m + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny] == 1){
                    arr[nx][ny] = 0;
                    Q.offer(nx*m + ny);
                }
            }
            
        }


    }
    public void solution(int n, int m, int[][] arr){
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 ){
                    answer++;
                    BFS(i,j, n,m,arr);
                }
            }
        }
        System.out.println(answer);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS1012 T = new BFS1012();
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        for(int i=0; i<C; i++){
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int [][] board = new int[n][m];
        for(int j=0; j<k; j++){
            int p = in.nextInt();
            int q = in.nextInt();
            board[q][p] = 1;
            }
        T.solution(n,m,board);

        }
        in.close();
    }
}
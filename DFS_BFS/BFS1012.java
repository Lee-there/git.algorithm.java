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

/*
팁1. 우리가 보통 좌표라고 사용하는 (x,y)랑 배열의 인덱스 arr[i][j]에서의 (i,j)는 서로 반대이다.
만약 입력값이 좌표일 떄 코드의 실수를 줄이려면 입력 단계에서는 int x,y 순으로 받은 후 arr[y][x]로
정리해주며 반복문 단계에서는 그냥 (i,j) 사용하면 된다(대신 i,j의 범위만 Outofbound 안나게 
좀 더 신경쓰기)
주의 1. 다음 문제는 가로길이 세로길이 순으로 변수 받음, 좌표도 (x,y)로 받는다
        -> 받은 변수를 배열 인덱스값으로 넣을 때 중의 하자 
        ex) 변수 m,n순서로 받고 board[n][m]으로 넣기, 변수 p,q 순으로 넣고 board[q][p]로 넣기
 */
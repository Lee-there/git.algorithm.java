package chapter9;
import java.util.*;


public class chapter9_12 {
    static int n, m;
    static int[][] dis, board;
    static Queue<Point> Q;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public void BFS(){
        while(!Q.isEmpty()){
                Point tmp = Q.poll();
                for(int j=0; j<4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx <n && ny>=0 && ny<m && board[nx][ny]==0){
                        board[nx][ny] =1;
                        dis[nx][ny] = dis[tmp.x][tmp.y] +1 ;
                        Q.offer(new Point(nx,ny));
                    }
                }
 
        }
        
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_12 T = new chapter9_12();
        Scanner in = new Scanner(System.in);
        m = in.nextInt(); 
        n = in.nextInt(); 
        board  = new int[n][m];
        dis = new int[n][m];
        Q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = in.nextInt();
                if(board[i][j] == 1) Q.offer(new Point(i,j));
            }
        }
        T.BFS();
        boolean flag = true;
        int  answer = Integer.MIN_VALUE; 
        for(int i=0 ; i<n; i++){
            for(int j=0; j<m; j++){
                if (board[i][j] == 0) flag = false;
            }
        }
        if(flag){
              for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                answer = Math.max(answer, dis[i][j]);
            }
        }
            System.out.println(answer);
        }else System.out.println(-1);
        in.close();
    }
}
/*  내가 짠 코드
 static int n, m, day = 1;
    static int[][] dis;
    static Queue<Point> Q;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int BFS(int[][] arr){
        int max = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Point tmp = Q.poll();
                for(int j=0; j<4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx <n && ny>=0 && ny<m && arr[nx][ny]==0){
                        arr[nx][ny] =1;
                        dis[nx][ny] = day;
                        Q.offer(new Point(nx,ny));
                    }
                }
            }
            day++;
        }
        
             for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0) return -1;
                max = Math.max( max , dis[i][j]);   
            }
        }
            
       return max; 
    }
       개선1. 강의 코드는 day함수 사용 안하고 diS[][] +1 사용하여 변수 더 적게 사용(day 사용보다 실수 확률 적음)
       개선1 추가. 내 코드의 len을 통한 for문은 day 변수 때문에 필요함 (dis[][]+1 사용이 더 좋은 이유)
       개선2. 만약 내 코드에서 day를 더 잘 사용했더라면 
              max = Math.max( max , dis[i][j]);이 코드는 전혀 사용할 필요가 없었음
       개선3. 내 코드는 토마토가 처음부터 다 익어있었거나 Q가 비어있었다면 틀린 코드가 된다
              -> 내 코드를 맞게 바꾸려면 일단 day =0으로 시작해야 됐으며 while문 안에 boolean 
              변수를 하나 추가하며 토마토 상태에 변화가 있는지 없는지 구분 후 있을 경우에만 
              day++ 해야된다
              ex)
              public int BFS(int[][] arr) {
    int max = 0;
    while (!Q.isEmpty()) {
        int len = Q.size();
        boolean pushed = false; // 이번 날짜에 새로 익은 토마토가 있는지 확인

        for (int i = 0; i < len; i++) {
            Point tmp = Q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = tmp.x + dx[j];
                int ny = tmp.y + dy[j];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = day; // 현재 날짜 기록
                    pushed = true;     // 새로 익힌 토마토가 있음!
                }
            }
        }
        if (pushed) day++; // 실제로 새로 익은 토마토가 있을 때만 다음 날로 넘어감
    }

    // 결과 확인
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] == 0) return -1;
            max = Math.max(max, dis[i][j]);
        }
    }
    return max;
}
    */

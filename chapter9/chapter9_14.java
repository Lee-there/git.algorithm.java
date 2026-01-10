package chapter9;
import java.util.*;

public class chapter9_14 {
    //섬나라 아일랜드 BFS 버전
    static int[][] board;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int a;
    static int answer = 0;
    public void BFS(int x , int y){
        board[x][y]=0;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0; i<8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx <a && ny>=0 && ny<a && board[nx][ny] == 1){
                    board[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }

    }
    public void solution(){
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                if(board[i][j] == 1){
                    answer++;
                    BFS(i,j);
                    
                }
            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_14 T = new chapter9_14();
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        board = new int[a][a];
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                board[i][j] = in.nextInt();
            }
        }
        T.solution();
        System.out.println(answer);
        in.close();
    }
    
}
/* 위 풀이가 내 풀이임
    강의 풀이는 앞 DFS 풀이랑 비슷해 내 풀이가 더 좋은 것 같아 변경하지 않음
 */

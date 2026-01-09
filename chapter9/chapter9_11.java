package chapter9;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class chapter9_11 {
    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public void BFS(int x , int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        board[x][y] = 1;
        while(!Q.isEmpty()){
                Point tmp = Q.poll();
                for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(1<= nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
            
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_11 T = new chapter9_11();
        Scanner in = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1;j<=7; j++){
                board[i][j] = in.nextInt();
            }
        }
        T.BFS(1,1);
        if(dis[7][7] == 0) System.out.println(-1); // 도착 못했을 경우
        else System.out.println(dis[7][7]);
        in.close();
    }
}

/*
**첫 코드**
public class chapter9_11 {
    static int[][] board = new int[8][8];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 0;

    public void BFS(int x , int y){
        board[x][y] = 1;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()){
            int len = Q.size();
            answer++;
            for(int j=0 ; j<len; j++){
            Point tmp = Q.poll();
                for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(1<= nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0){
                    if(nx == 7 && ny == 7) return;
                    Q.offer(new Point(nx,ny));
                    board[nx][ny]=1;
                    
                }
            }
            }
            
        }
    }
}
    보완 1. 아직 BFS 형식이 미흡함 (Poll하는 위치, len 값 구하는 위치 및 len 을 통한 for문 사용, answer++위치)
    보완 2. board[x][y] = 1;를 통한 실수 방지
    보완 3. answer++ 대신 dis배열을 통해 좀 더 간단하고 효율적인 코드 생성 가능
 */
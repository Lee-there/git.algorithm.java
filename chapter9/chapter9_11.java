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
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 0;
    public void BFS(int x , int y){
        Queue<Point> Q = new LinkedList<>();



    }
    public static void main(String[] args) {
        chapter9_10 T = new chapter9_10();
        Scanner in = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1;j<=7; j++){
                board[i][j] = in.nextInt();
            }
        }
        T.BFS(1,1);
        System.out.println(answer);
        in.close();
    }
}

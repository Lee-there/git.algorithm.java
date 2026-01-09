package chapter9;
import java.util.*;

public class chapter9_10 {
    static int[][] board = new int[8][8];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 0;
    public void DFS(int x, int y){
        board[x][y]=1;
        if(x == 7 && y == 7){
            answer++;
        }else{
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                 if(1<= nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                DFS(nx,ny);
                board[nx][ny] = 0;
            }
            }
            
        }
        board[x][y] = 0;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_10 T = new chapter9_10();
        Scanner in = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1;j<=7; j++){
                board[i][j] = in.nextInt();
            }
        }
        T.DFS(1,1);
        System.out.println(answer);
        in.close();
    }
}

/*1.처음 문제를 봤을 때 예전 봉우리 문제 생각남(dx랑 dy통한 이동)
  2.경로 이동이 있어 혹시 ch배열로 경로 저장해야 된는 줄 알았지만 코드 짜는 과정에서 필요 없음 확인
  3.한 경로 찾은 후에 다시 (1,1)로 돌아가야 된다는 생각 때문에 결국 코드 완성 못하고 구현 원리 봄

**구현 원리 확인 후 코드**
public class chapter9_10 {
    static int[][] board = new int[8][8];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 0;
    public void DFS(int x, int y){
        if(x == 7 && y == 7){
            answer++;
        }else{
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                 if(1<= nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                DFS(nx,ny);
                board[nx][ny] = 0;
            }
            }  
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_10 T = new chapter9_10();
        Scanner in = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1;j<=7; j++){
                board[i][j] = in.nextInt();
            }
        }
        board[1][1]=1;
        T.DFS(1,1);
        System.out.println(answer);
        in.close();
    }
}
  고칠 점 1. 1<= nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny] == 0 와 
             board[nx][ny] == 0 && 1<= nx && nx<=7 && 1<=ny && ny<=7 차이 인지해야됨
             밑의 코드는 array.outofbound 오류가 뜬다
        2. board[1][1]=1 메인 함수의 이 코드를 빼고 DFS 함수 내에서 시작 시점과 끝 지점에 코드를 
           추가해 줘서 실수를 줄이고 더 대칭적인 코드 생성
 */
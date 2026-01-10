package chapter9;
import java.util.*;

public class chapter9_13 {
    //섬나라 아일랜드 DFS 버전
    static int[][] board;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int a;
    static int answer = 0;
    public void DFS(int x , int y){
       for(int i=0; i<8;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx>=0 && nx <a && ny>=0 && ny<a && board[nx][ny] == 1){
            board[nx][ny]=0;
            DFS(nx,ny);
        }
       }
    }
    public void solution(){
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                if(board[i][j] == 1){
                    answer++;
                    board[i][j]=0;
                    DFS(i,j);
                }
            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_13 T = new chapter9_13();
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

/* 내 코드
    static int[][] board;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int a;
    static int answer = 0;
    public void DFS(int x , int y){
        board[x][y]=0;
       for(int i=0; i<8;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx>=0 && nx <a && ny>=0 && ny<a && board[nx][ny] == 1){
            DFS(nx,ny);
        }
       }
    }
    public void solution(){
        chapter9_13 T = new chapter9_13();
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                if(board[i][j] == 1){
                    T.DFS(i,j);
                    answer++;
                }
            }
        }

    }
        1.개인적으로 강의 코드보다 내 코드가 논리가 명확한 코드라 생각함(DFS 시작 시 방문 지점 바로 0 변경 후 시작)
        2. 내 코드는 board 방문 시 0이 되는 작동이 DFS 내에 존재하기 떄문에 answer++의 위치를 
           DFS 앞에 넣든 뒤에 넣든 영향을 받지 않는다
        개선1. 처음 혼자 풀 때 꼭 DFS 함수 하나로 문제를 풀려고 함(solution함수도 사용할 수 있음)
               -> 항상 열린 마음 갖자^^;
         */
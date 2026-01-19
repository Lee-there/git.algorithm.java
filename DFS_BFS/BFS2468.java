import java.util.*;

class BFS2468 {
    static int n, max = Integer.MIN_VALUE;
    static int answer = 1;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    public void BFS(int k ,int h, boolean[][] ch){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(k);
        ch[k/n][k%n] = true;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp/n + dx[i];
                int ny = tmp%n + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] > h  && !ch[nx][ny]){
                    ch[nx][ny] = true;
                    Q.offer(nx*n+ny);
                }
            }
        } 
        
    }
    public void solution(){
        for(int k=0; k<=max; k++){
            int region = 0;
            boolean[][] ch = new boolean[n][n]; 
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] > k && !ch[i][j]){
                        region++;
                        BFS(i*n+j,k,ch);
                    }                   
            }
        }
        answer = Math.max(answer, region);
        }
        System.out.println(answer);
        
        
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS2468 T = new BFS2468();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int k = in.nextInt();
                max = Math.max(max , k);
                board[i][j] = k;
            }
        }
        T.solution();
        in.close();
    }
}
/* GEMINI 개선 ver
import java.util.*;
class BFS2468 {
    static int n, maxH = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    // 1. BFS를 좌표(r, c)와 현재 비 높이(h)를 직접 받게 설계
    public void BFS(int r, int c, int h, boolean[][] visited) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{r, c});
        visited[r][c] = true;
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                // 복잡한 board[nx][ny] != 0 대신, 문제 조건 그대로 "h보다 높은가"만 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] > h) {
                    visited[nx][ny] = true;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    public void solution() {
        int maxRegion = 1; // 아무것도 안 잠기면 영역은 1개
        // 비의 높이 k를 0부터 maxH까지 (브루트포스)
        for (int k = 1; k < maxH; k++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // "현재 비 높이(k)보다 높고 방문 안 한 곳" 찾기
                    if (board[i][j] > k && !visited[i][j]) {
                        count++;
                        BFS(i, j, k, visited); // 덩어리 지우기
                    }
                }
            }
            maxRegion = Math.max(maxRegion, count);
        }
        System.out.println(maxRegion);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                maxH = Math.max(maxH, board[i][j]);
            }
        }
        new BFS2468().solution();
    }
}
개선 1.처음 문제를 풀 때 board함수의 값이 k이면 if(board[i][j]==k) board[i][j] = 0;으로 바꿈(데이터 변형.훼손) 
        이 경우보다는 그냥 조건을 통해 board[i][j]>k인 값들을 확인하는 방법이 더 안전함
       -> 원본 데이터는 훼손하지 않는게 좋다
개선 2. 실수를 줄이기 위해 i*n+j보다 그냥 Queue에다가 int[]{i,j} 추가해보자 (실수 줄일 수 있음)
개선 3. 전역 변수 최소화하고 solution함수 내에 정의하는 것이 데이터 꼬임을 방지함
개선4. 문제가 복잡하다보니 기본적인 BFS형식인 첫 방문 ch하는 것을 까먹음 복잡하더라도 항상 
       틀린게 있다면 기본적인 것부터 뭐가 틀렸는지 확인하기


고치기 전 틀렸던 가장 최근 코드
class BFS2468 {
    static int n, max = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;  //문제 지점 1
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    public void BFS(int k , boolean[][] ch){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(k);
        //문제2. 시작점 방문 체크 필요
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp/n + dx[i];
                int ny = tmp%n + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] != 0 && !ch[nx][ny]){
                //문제3. if 조건에서 board[nx][ny] != 0 변경
                    ch[nx][ny] = true;
                    Q.offer(nx*n+ny);
                }
            }
        }
    }
    public void solution(){
        for(int k=0; k<=max; k++){
            int region = 0;
            boolean[][] ch = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] <= k) board[i][j] = 0;
                    //문제4. 원본 회손 금지
                    else if(board[i][j] != 0 && !ch[i][j]){
                      region++;
                      BFS(i*n+j, ch);
                    }                    
            }
        }
        answer = Math.max(answer, region);
        }
        System.out.println(answer);}
 */

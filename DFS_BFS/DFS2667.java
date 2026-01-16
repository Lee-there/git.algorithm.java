import java.util.*;

class DFS2667{
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int IN = 0 , IS;
    public void DFS(int x , int y){
        arr[x][y] = 0;
        IS++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>0 && nx<=n && ny>0 && ny<=n && arr[nx][ny] == 1){
                DFS(nx,ny);
            }
        }
    }
    public void solution(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                IS = 0;
                if(arr[i][j] == 1){
                    IN++;
                    DFS(i,j);
                }
                if(IS != 0){
                    ans.add(IS);
                }
            }
        }

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        DFS2667 T = new DFS2667();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
                String line = in.next();
                for(int j=1; j<=n; j++){
                    arr[i][j] = line.charAt(j-1) - '0';
                } 
        }
        T.solution();
        System.out.println(IN);
        Collections.sort(ans);
        for(int x : ans) System.out.println(x);
        in.close();
    }
}
/*
개선 1. solution함수를 이렇게 변형하면 좀 더 깔끔한 코드 탄생
public void solution(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1){
                    IS = 0;
                    IN++;
                    DFS(i,j);
                    ans.add(IS);
            }
        }
    }
개선 2. 현재 문제는 n의 크기가 <= 25로 작아 문제가 없지만 지도가 커지면 StackOverflowError가 뜰 수 있음
 BFS로 다시 풀어보자
개선 3. 전역 변수를 너무 많이 사용하면 코테는 상관없지만 실무에서는 여러 번 실행할 떄 번거러울 수 있음 
        -> solution함수 돌 때마다 전역 변수 초기화하거나 전역 변수 줄이기
 */
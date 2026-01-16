import java.util.*;
class Point{
    int x, y;
    Point(int x , int y){
        this.x = x;
        this.y = y;
    }
}
class BFS2667 {
    static int n;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int IN = 0 , IS;
    static ArrayList<Integer> ans = new ArrayList<>();

    public void BFS(int x, int y){
        arr[x][y] = 0;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            IS++;
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(1<=nx && nx<=n && 1<=ny && ny<=n && arr[nx][ny] == 1){
                    arr[nx][ny] = 0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public void solution(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1){
                    IS = 0;
                    IN++;
                    BFS(i,j);
                    ans.add(IS);
                }
            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS2667 T = new BFS2667();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            String k = in.next();
            for(int j=1; j<=n; j++){
                arr[i][j] = k.charAt(j-1) - '0';
            }
        }
        T.solution();
        System.out.println(IN);
        Collections.sort(ans);
        for(int x : ans){
            System.out.println(x);
        }
        in.close();
    }
}
/*
2667 문제 BFS DFS로 푼 것에 대한 피드백
1.  BFS함수와 solution함수를 나눔으로써 좀 더 수워하게 풀 수 있었음
    -> 꼭 BFS DFS함수 하나로 답 도출하겠다는 생각 지우기
2. 입력이 
0110100
0110101
1110101
이렇게 각각 숫자가 아닌 뭉텅이로 들어오면 한 줄씩 String으로 받고 각각 int로 바꿔주는 과정 필요(복습) 
3. BFS내에 Queue 생성 시 호출할 때마다 생성해서 비효율적
   -> Queue 전역변수로 만들고 BFS 시행시마다 큐 초기화 
4. Point 클래스 사용보다는 좌표변환을 사용하는게 메모리 관리 측면에서 굉장히 효율적임
   -> [1차원 인덱스 변환 공식]2차원 좌표를 1차원 숫자로 변환
   공식: 번호 = (행 번호 * 전체 열의 개수) + 열 번호
   복구: 행 = 번호 / 전체 열의 개수, 열 = 번호 % 전체 열의 개수
   ex)5X5 지도에서 (2, 3) 좌표를 큐에 넣고 싶다면, 단순히 2 * 5 + 3 = 13이라는
      숫자 하나만 큐에 넣으면 됨
      꺼낼 때는 13 / 5 = 2, 13 % 5 = 3으로 다시 좌표를 얻을 수 있음 */
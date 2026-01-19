import java.util.*;

class BFS4963{
    static int[] dx = {0, 1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public void BFS(int x, int y, int[][] arr ){
        int p = arr.length;
        int q = arr[0].length;
        arr[x][y] =0;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x,y});
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            for(int i=0; i<8; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx>=0 && nx < p && ny>=0 && ny<q && arr[nx][ny] == 1){
                    arr[nx][ny] = 0;
                    Q.offer(new int[] {nx,ny});
                }
            }
        }
    }

    public void solution(int[][] arr){
        int answer = 0;
        int p = arr.length;
        int q = arr[0].length;
        for(int i=0; i<p; i++){
            for(int j=0; j<q; j++){
                if(arr[i][j] == 1){
                    answer++;
                    BFS(i,j,arr);
                }
            }
        }
        System.out.println(answer);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS4963 T = new BFS4963();
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            int m = in.nextInt();
            if(n == 0 && m == 0) break;
            int[][] arr = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = in.nextInt();
                }
            }
            T.solution(arr);
        }
        in.close();
    }
}

/* 
팁1. 이차원 배열의 row는 arr.length로 col은 arr[0].length로 구할 수 있다 
팁2. 큐 안에 int[] 넣으면 가독성 높아지고 속도 느려짐 반면에 x*m+y 넣으면 가독성 줄고 속도 올라감
개선1. (*)어차피 while 돌면서 계속 n,m 바뀌니까 그냥 전역변수로 넣어도 됐을듯
개선2. (*****) 원본을 보존할 필요가 있는 문제는 ch배열을 if 문 안에 넣어 조건문을 완성하고
       원본을 보존할 필요가 없는 문제는 보통 ch배열을 사용하지 않는다*/
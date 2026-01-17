import java.util.*;

class BFS11724{
    static int n,m;
    static int[][] board;
    static int[] ch;
    public void BFS(int x){
        ch[x] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=1; i<=n; i++){
                if(board[tmp][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    Q.offer(i);
                }
            }
        }        
    }
    public int solution(){
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(ch[i] == 0){
                BFS(i);
                answer++;
            }
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS11724 T = new BFS11724();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        ch = new int[n+1];
        board = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            board[p][q] = 1;
            board[q][p] = 1;
        }
        System.out.println(T.solution());
        in.close();
    }
}
/*
개선 1. 문제 풀 때 BFS의 if문 내에 ch[i] == 0 라는 조건을 추가해주지 않아
        무한 루프에 걸리는 문제 발생
개선 2. 배열보다 ArrayList 사용하는 것이 메모리 측면이나 속도 측면에서 훨씬 효율적
        -> 다음 문제부터는 가급적 ArrayList 많이 사용하기 */
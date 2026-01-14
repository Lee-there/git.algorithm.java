
import java.util.*;

class DFS1260{
    static int n , m , s;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public void DFS(int v){ // 순서 문제가 이니므로 초기값을 L이 아닌 현 위치 v로 설정한다
        
    }
    public void BFS(){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while(!Q.isEmpty()){

        }

    }
    public static void main(String[] args) {
        DFS1260 T = new DFS1260();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i< m; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            graph.get(p).add(q);
            graph.get(q).add(p);
        }
        ch = new int[n+1];
        ch[s] = 1;
    }
}
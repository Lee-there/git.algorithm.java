package chapter8;
import java.util.*;

public class chapter8_14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        Q.offer(v);
        while(!Q.isEmpty()){
            int cv = Q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cv]+1;
                }
            }
        }
    }


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
    

    chapter8_14 T = new chapter8_14();
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();
    graph = new ArrayList<>();
    for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
    }
    ch = new int[n+1];
    dis = new int[n+1];
    for(int i=0; i<m; i++){
        int a = in.nextInt();
        int b = in.nextInt();
        graph.get(a).add(b);
    }
    T.BFS(1);
    for(int i = 2; i<=n; i++){
        System.out.println(i+ " : " + dis[i]);
    }
    in.close();
    }
}

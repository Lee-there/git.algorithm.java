package chapter10;
import java.util.*;
 
/*
복습1. 그림 그려보면서 알고리즘 진행 과정 확인 필수
복습2. 알고리즘 아이디어 확인 밑 Edge 클래스 사용, 오버라이드 사용 복습
복습3. continue를 통한 필요 없는 계산 줄이기 확인 */
class Edge implements Comparable<Edge>{
    public int vex; //정점
    public int cost; //비용
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

public class chapter10_5 {
//다익스트라 알고리즘
static int n,m;
static ArrayList<ArrayList<Edge>> graph;
static int[] dis;
public void solution(int v){
    PriorityQueue<Edge> pQ = new PriorityQueue<>(); // 이렇게 되면 Edge 오버라이드에 의해 코스트 작은 것부터 꺼내짐
    pQ.offer(new Edge(v,0));
    dis[v] = 0;
    while(!pQ.isEmpty()){
        Edge tmp = pQ.poll();
        int now = tmp.vex;
        int nowCost = tmp.cost;
        if(nowCost>dis[now]) continue;
        for(Edge ob : graph.get(now)){
            if(dis[ob.vex]>nowCost + ob.cost){
                dis[ob.vex] = nowCost+ob.cost;
                pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
            }
        }
    }
}
@SuppressWarnings("ConvertToTryWithResources")
public static void main(String[] args) {
    chapter10_5 T = new chapter10_5();
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();
    graph = new ArrayList<>();
    for(int i=0; i<=n; i++){
        graph.add(new ArrayList<Edge>());
    }
    dis = new int[n+1];
    Arrays.fill(dis,Integer.MAX_VALUE);
    for(int i=0; i<m; i++){
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        graph.get(a).add(new Edge(b,c));
    }
    T.solution(1);
    for(int i=2; i<=n; i++){
        if(dis[i] != Integer.MAX_VALUE) System.out.println(i+" : " + dis[i]);
        else System.out.println(i+ " : impossible");
    }
    in.close();
} 
}

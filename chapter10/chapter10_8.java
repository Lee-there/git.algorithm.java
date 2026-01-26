package chapter10;
import java.util.*;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class chapter10_8 {
    // 최소스패닝트리 : 프림, PriorintyQueue 알고리즘
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int ev = tmp.vex;
            if(ch[ev] == 0){
                ch[ev] = 1;
                answer += tmp.cost;
                for(Edge o : graph.get(ev)){
                    if(ch[o.vex] == 0) pQ.offer(new Edge(o.vex, o.cost));
                }
            }
        }
        System.out.println(answer);
        in.close();
    }
    
}
/* 
보통 PriorityQueue를 사용할 경우 Edge클래스처럼 변수 클래스에 오버라이딩을 통한 우선순위를 정해주는
 것이 보편적이나 때에 따라 
 1.람다식을 사용하여 Edge의 가중치(weight) 기준 오름차순 정렬
PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
2. // Comparator.comparing을 이용한 깔끔한 방식
PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
이렇게 직접 우선순위를 정해줄 수 있다 
*/
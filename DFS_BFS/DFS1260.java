
import java.util.*;

class DFS1260{
    static int n , m , s;
    static int[] ch;
    static int[][] graph;
    public void DFS(int v){ // 순서 문제가 이니므로 초기값을 L이 아닌 현 위치 v로 설정한다
        ch[v] = 1;
        System.out.print(v + " ");
                for(int i=1; i<=n; i++){
                    if(graph[v][i] == 1 && ch[i] == 0){
                        DFS(i);
                }
            }  
    }
    public void BFS(int s){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s] = 1;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            System.out.print(tmp + " ");
            for(int i=1; i<=n; i++){
                if(graph[tmp][i] == 1 && ch[i]==0){
                    ch[i] = 1;
                    Q.offer(i);
                }
            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        DFS1260 T = new DFS1260();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        graph = new int[n+1][n+1];
        
        for(int i = 0; i< m; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            graph[p][q] = 1;
            graph[q][p] = 1;
        }
        ch = new int[n+1];
        T.DFS(s);
        Arrays.fill(ch,0); // ch 배열 초기화
        System.out.println();
        T.BFS(s);
        in.close();
    }
}

/*
tip1. ch배열을 0과1이 아닌 boolean형으로 하면 좀 더 효율적인 코드가 된다
DFS 작성 문제점
1. DFS는 그 자체로 재귀 호출되므로 첫 작성 때 while문을 통한 코드 작성은 문제가 있음
   ex)  while(flag){ // 이런 느낌으로 풀려고 함
            for(int nv : graph.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                }  
2. if-else 형식을 써야 된다는 고정관념 (틀에 코드를 맞추려고 하니까 더 어려움을 느낌)
3.정렬과 인접 행렬의 장단점 알기 (보통 인접 행렬은 정점이 많고 간선이 적을 때 사용)
  -> 다음 문제는 번호가 작은 것부터 방문이라는 조건이 있었음 이 조건을 보고 인접행렬보다는 
     정렬이 좋겠다는 발상 필요
BFS 작성 문제점   
1.문제 자체를 잘못 이해함(그래프를 BFS로 탐색한 결과-> 한 점이 이동하는 느낌이 아니라 한 점에서 다음
                        이동 가능한 점들로 점들이 퍼져나가는 느낌이라는 걸 알아야 됨)  */
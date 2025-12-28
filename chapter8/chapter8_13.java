package chapter8;
import java.util.*;
/* 경로탐색(인접 리스트 버전) */


public class chapter8_13 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }

        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter8_13 T = new chapter8_13();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<= n; i++){  
            //ArrayList는 0번부터 저장되니까 그냥 n+1개 add후 0번 ArrayList 사용 안해버리기
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
        in.close();
    }
}

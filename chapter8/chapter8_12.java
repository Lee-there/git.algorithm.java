package chapter8;
import java.util.*;

public class chapter8_12 {
    /* 경로탐색(DFS) */
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){ 
        if(v==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1; 
                    DFS(i);
                    ch[i] = 0;
                }

            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter8_12 T = new chapter8_12();
        Scanner in = new Scanner(System.in);
         n = in.nextInt();
         m = in. nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int c = in.nextInt();
            int d = in.nextInt();
            graph[c][d] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
        in.close();
    }
}

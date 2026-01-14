package Beakjoon;
import java.util.*;

class DFS1260{
    static int n , m , s;
    static int[][] arr;
    static int[] ch;
    public void DFS(int L){
        if(L == n){
            
        }else{
            
            
        }
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
        arr = new int[n][n];
        for(int i = 0; i< m; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            arr[p][q] = 1;
            arr[q][p] = 1;
        }
        ch = new int[n+1];
        ch[s] = 1;
    }
}
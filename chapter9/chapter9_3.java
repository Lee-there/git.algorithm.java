package chapter9;
import java.util.*;

public class chapter9_3 {
    //확실히 9_1이랑 9_2랑 비슷한 문제라 쉽게 푼 느낌
    static int n,m;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;
    public void DFS(int L, int sum, int time){
        if(time>m) return;
        if(L == n){ 
            answer = Math.max(answer, sum);
        }else{
            DFS(L+1, sum+arr[L][0], time+arr[L][1] );
            DFS(L+1, sum, time);
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_3 T = new chapter9_3();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        T.DFS(0,0,0);
        System.out.println(answer);
        in.close();
    }
    
}

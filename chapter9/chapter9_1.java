package chapter9;
import java.util.*;

public class chapter9_1 {
    static int n, total = 0;
    static String answer = "NO";
    boolean flag = false;
    public void DFS(int L , int sum, int[] arr){

    }

    public static void main(String[] args) {
        chapter9_1 T = new chapter9_1();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr); // L이랑 sum이 0부터 시작이라 0 넣는거임
        System.out.println(answer);      
    }
}

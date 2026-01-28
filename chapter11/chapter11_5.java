package chapter11;
import java.util.*;

public class chapter11_5 {
    static int n,m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0; i<n;i++){
            for(int j=coin[i]; j<=m; j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
      chapter11_5 T = new chapter11_5();
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      int[] arr = new int[n];
      for(int i=0; i<n; i++){
        arr[i] = in.nextInt();
      }
      m = in.nextInt();
      dy = new int[m+1];
      System.out.println(T.solution(arr));
      in.close();
    } 
}

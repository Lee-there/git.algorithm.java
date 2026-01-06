package chapter9;
import java.util.*;

public class chapter9_5 {
   static int n,m;
   static Integer[] arr;
   static int answer = Integer.MAX_VALUE;
   public void DFS(int L, int sum){
      if(sum > m) return;
      if(answer<=L) return; // 시간 복잡도 절약 가능
      if(sum == m){
        answer = L;
      }else{
         for(int i=0; i<n; i++){
            DFS(L+1, sum+ arr[i]);
         }
      }
   }
   @SuppressWarnings("ConvertToTryWithResources")
 public static void main(String[] args) {
    chapter9_5 T = new chapter9_5();
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    arr = new Integer[n];
    for(int i=0; i<n; i++){
      arr[i] = in.nextInt();
    }
    Arrays.sort(arr, Collections.reverseOrder()); // 내림차순으로 정렬하여 시간 복잡도 절약
    //위 내림차순 적용 사용하려면 int형이 아닌 Integer형 사용해야됨 (int형을 객체형인 Integer로 변경)
    m = in.nextInt();
    T.DFS(0, 0);
    System.out.println(answer);
    in.close();
 }
}


 

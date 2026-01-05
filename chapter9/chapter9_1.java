package chapter9;
import java.util.*;

public class chapter9_1 {
    /* 집합에서 각 원소들을 넣을지 말지로 트리를 구성해 나가면서 내려가는 구조 */
    static int n, total = 0;
    static String answer = "NO";
    boolean flag = false;
    public void DFS(int L , int sum, int[] arr){
        if(flag) return;  // flag가 true가 되는 순간 모든 스텍 다 return됨
        if(sum>total/2) return; // 불필요한 계산들 그냥 다 return
        if(L==n){
            if((total-sum) == sum){
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
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
        in.close();    
    }
}

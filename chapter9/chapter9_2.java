package chapter9;
import java.util.*;

public class chapter9_2 {
    /* 혼자 코드 짜면서 아쉬웠던 부분들 번호 순으로 적었으니 복습하기 */
    static int Max = Integer.MIN_VALUE;
    static int n, m;
    public void DFS(int L, int sum, int[] arr){
        if(n<sum) return;
        if(L == m ){
            // 1. 처음 return문 넣었던 곳 (고친 위치가 더 효율적인 코드 구현 가능)
            // 2. 밑에 코드를 사용하는 것도 좋음 방법 [ if(sum> Max) Max = sum; ]
            Max = Math.max(Max,sum);
        }else{
            DFS(L+1,sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_2 T = new chapter9_2();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<m; i++){
            arr[i] = in.nextInt();
        }
        T.DFS(0,0,arr);
        System.out.println(Max);
        in.close();
    }
}   /*
      static int Max = Integer.MIN_VALUE;

    static int Dif = Integer.MAX_VALUE;

    static int n, m;

    public void DFS(int L, int sum, int[] arr){

        if(L == m ){

            if(n<sum) return;

            if((n-sum) < Dif) Max = sum;

        }else{

            DFS(L+1,sum+arr[L], arr);

            DFS(L+1, sum, arr);

        }

    } 
    3. 내가 처음 짠 코드임 일단 Max와 Min 변수 2개 구현한 부분이 효율적이지 않으며
       심지어 Dif변수는 sum과 Max는 계속 바뀌는 와중에 같이 바뀌지도 않음 (비효율적이고 잘못된 코드) */

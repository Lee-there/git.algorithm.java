package chapter9;
import java.util.*;

public class chapter9_9 {
    /* 조합 구하기 문제
       내가 짠 코드에서는 비슷했지만 ch배열을 만들어 비효율적인 코드가 됨 (이미 int S라는 변수를 통해 
       DFS가 넘어갈 때 마다 방금 추가한 i보다 큰 수만 넣을 수 있게 코드를 짬) -> 중복이 생길 수 없음
     */
    static int n, m;
    static int[]  arr;
    public void DFS(int L, int S){ // S 는 조합이 추가할 수 있는 숫자 중 최소인 숫자
        if(L == m){
            for(int x : arr) System.out.print(x+ " ");
            System.out.println();
        }else{
            for(int i=S; i<=n; i++){ // 다음 DFS에서 i+1부터 탐색하기 때문에 체크 배열을 사용할 필요가 없게 됨
                    arr[L] = i;
                    DFS(L+1, i+1); // i가 추가된 순간 그 이후의 숫자만 사용       
            }
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_9 T = new chapter9_9();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];
        T.DFS(0, 1);
        in.close();
    }
}

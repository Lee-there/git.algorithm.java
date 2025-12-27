package chapter8;
import java.util.*;

public class chapter8_6 {
    /* DFS를 이용해 1부터 n까지를 원소로 갖는 집합의 모든 부분집합을 출력함 */
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L == n+1){ // 한 부분집합이 완성됐을 때 그 부분집합을 출력하기 위한 코드
            String tmp = "";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) tmp += (i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{ // 스택 쌓이는 과정을 천천히 확인하면서 부분집합을 어떻게 구하는지 생각해보자
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }


    @SuppressWarnings("ConvertToTryWithResources")
   public static void main(String[] args) {
     chapter8_6 T = new chapter8_6();
    Scanner in = new Scanner(System.in);
     n = in.nextInt();
    ch = new int[n+1];
    T.DFS(1);
    in.close();
   }

}

package chapter9;
import java.util.*;

public class chapter9_6 {
    //순열 구하기(중복 불가능) -> ch배열 만들어서 경로 추적 기능 추가
    static int n,m;
    static int[] arr;
    static int[] pm;
    static int[] ch;
    public void DFS(int L){
        if(L == m){
            for(int x : pm){
                System.out.print(x+" ");
            }
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(ch[i] != 1){
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
      chapter9_6 T = new chapter9_6();
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      m = in.nextInt();
      arr = new int[n];
      ch = new int[n];
      for(int i=0; i<n; i++){
        arr[i] = in.nextInt();
      }
      pm = new int[m];
      T.DFS(0);
      in.close();
    }
}

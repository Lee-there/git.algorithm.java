package chapter9;
import java.util.*;

public class chapter9_4 {
    // 중복순열 문제
    static int[] pm;
    static int n,m;
    public void DFS(int L){
        if(L == m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[L] = i;
                DFS(L+1);
            }
            
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_4 T = new chapter9_4();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        T.DFS(0);
        in.close();
    }
}


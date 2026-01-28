package chapter10;
import java.util.*;

public class chapter10_6 {
    //Uion&Find 알고리즘
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]); 
        /* return Find(unf[v])를 사용하는 것보다 
        return unf[v]=Find(unf[v]) 사용으로 속도 업*/ 
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;
        for(int i=1; i<=m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Union(a,b);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa== fb) System.out.println("YES");
        else System.out.println("NO");
        in.close();
    }
}
/*
복습 1. find함수의 else return 부분 unf[v]를 통한 압축 과정을 이해해야됨
복습 2. 그림 그려보면서 코드 진행 과정 파악 필요 (파악 후 코드 그냥 외워라)
 */
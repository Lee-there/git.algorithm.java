package chapter9;
import java.util.*;

public class chapter9_7 {
    static int[][] dy = new int[35][35]; // 대충 35로 저장
    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r]; // 이 코드를 통해 시간 단축 가능 (메모이제이션)
        if(n==r || r==0) return 1;
        else return dy[n][r] =  DFS(n-1, r-1) + DFS(n-1,r);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_7 T = new chapter9_7();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(T.DFS(n,r));
        in.close();
    }
}


/* 
위 코드가 내가 구현한 코드의 개선된 코드임(배열을 통해 시간 복잡도 단축 가능)
public int Com(int n, int m){
        if(m == 0 || n == m) return 1;
        else return Com(n-1,m-1) + Com(n-1,m);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_7 T = new chapter9_7();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(T.Com(n,m));
        in.close();
    } */
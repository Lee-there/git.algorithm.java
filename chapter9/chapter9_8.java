package chapter9;
import java.util.*;


public class chapter9_8 {
    static int[] pm, qm, ch;
    boolean flag = false;
    int[][] dy = new int[35][35];
    static int p,q;
    public int combi(int n , int r){
        if(dy[n][r] > 0 ) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1,r-1) + combi(n-1,r);
    }
    public void DFS(int L , int sum){
        if(flag) return;   // 시간 복잡도 줄이기 위해 필요
       if(L == p){
        if(sum == q){
        for(int x : qm) System.out.print(x + " ");
        System.out.println();
        flag = true;
        
        }
       }else{ //for문으로 수열 만드는 알고리즘임(자주 쓰일듯 함)
        for(int i=1; i<=p; i++){ //for문 이렇게 사용하면 알아서 사전식이 됨
            if(ch[i] == 0){
                ch[i] = 1;
                qm[L] = i;
                DFS(L+1, sum + (pm[L]*qm[L]));
                ch[i] = 0;
            }
        }

       }
        
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_8 T = new chapter9_8();
        Scanner in = new Scanner(System.in);
        p = in.nextInt();
        pm = new int[p];
         for(int i=0; i<p; i++){
            pm[i] = T.combi(p-1,i);
        }
        qm = new int[p];
        q = in.nextInt();
        ch = new int[p+1];
        T.DFS(0,0);
        in.close();
        }
    }


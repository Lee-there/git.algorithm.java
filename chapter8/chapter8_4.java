package chapter8;
import java.util.*;
public class chapter8_4 {
    /*  
    **중요** 재귀는 프레임을 여러 개(스텍을 계속 쌓기 떄문에) 사용해서 느린 반면 
    for문은 프레임 하나만 사용해서 훨씬 더 빠르다
    
     그냥 DFS하는 것 보다 fibo라는 배열을 만들고 DFS가 커질 때마다
    저장해 놓으면 좀 더 빠르게 호출 가능
    if(fibo[n]>0) return fibo[n]; 이거 사용하면 맨날 처음부터 호출할 
    필요 없어서 더 빠름 */
    static int[] fibo;

    @SuppressWarnings("all")
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];  //배열이 초기에 0으로 설정됐으니까 0보다 크면 이미 나온 수
        if(n==1) return fibo[n] = 1;
        else if (n==2) return fibo[n] = 1;
        else return fibo[n] =  DFS(n-1) + DFS(n-2);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter8_4 T = new chapter8_4();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fibo = new int[n+1];
        T.DFS(n);      
        System.out.println(fibo[n]);
        in.close();
    }
}

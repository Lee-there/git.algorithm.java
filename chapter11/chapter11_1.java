package chapter11;
import java.util.*;

public class chapter11_1 {
    // 계단오르기 문제 (다이나믹 알고리즘)
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return(dy[n]);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter11_1 T = new chapter11_1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n+1];
        System.out.print(T.solution(n));
        in.close();
    }
}
/* 
문제를 작은 문제들의 모음으로 변형하여 쉽게 푸는 방법이라고 보면 될듯 */

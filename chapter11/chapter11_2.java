package chapter11;
import java.util.*;

public class chapter11_2 {
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n] + dy[n-1];
    }
    public static void main(String[] args) {
        chapter11_2 T = new chapter11_2();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}

/*개선된 코드
    dy = new int[n+2];한 뒤
    return dy[n+2] 해주기 
    -> 이 경우 코드가 더 깔끔하며 문제가 3칸까지 뛸 수 있다고 바뀔 시 반복문의 범위만 바꿔주면 됨
    */

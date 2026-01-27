package chapter11;
import java.util.*;

public class chapter11_3 {
    //최대부분증가수열(LIS)
    static int[] dy;
    public void solution(int[] arr, int n){
        dy[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j]>max){
                    max = dy[j];
                }
            }
            dy[i] = max+1;
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) answer = Math.max(answer, dy[i]);
        System.out.println(answer);
    }
    public static void main(String[] args) {
        chapter11_3 T = new chapter11_3();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        dy = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        T.solution(arr, n);
    }
}
/* 
복습 1. 처음 풀 때 int max = 1와 dy[i] = max 이 두 코드를 j for문 안에 넣어 문제가 생김
** 내 코드 ** 
public void solution(int[] arr, int n){
        dy[0] = 1;
        for(int i=1; i<n; i++){
            int max = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    max = Math.max(max, dy[j] + 1);
                }
            }
            dy[i] = max;
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) answer = Math.max(answer, dy[i]);
        System.out.println(answer);
    }
내 코드 보완점
1. 내 코드는 매번 max를 통해 비교 -> 속도 느려지며 max변수의 의미가 현재 발견한 최장 길이인지 비교 대상인지 
   모호해짐
2. 보통 LIS 문제는 역순이 코드 최적화나 특정 조건 추가했을 때 유리한 경향이 있어 역순 추천
         */

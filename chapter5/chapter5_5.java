package chapter5;
import java.util.*;

public class chapter5_5 {
    /* TreeSet에 대해 배움 (set은 중복 제거할 때 많이 사용하는 자료구조)
       1. add하면 알아서 올림차순으로 정렬됨 (중복 없음)
       2. Collections.reverseOrder() 사용하면 내림차순으로도 정렬 가능
       3. remove, size, first, last 등 다양한 기능 존재
       4. set에서 N번째로 큰 값 구하려면 Array로 바꾸거나 밑 코드처럼 따로 구해야 됨
          */
    public int solution(int a, int b, int[] num){
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<a; i++){
            for(int j= i+1; j<a; j++){
                for(int l=j+1; l<a; l++){
                    Tset.add(num[i] + num[j] + num[l]);
                }
            }
        }
        int cnt = 0;
        for(int x : Tset){
            cnt++;
            if(cnt == b) return x;

        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter5_5 T = new chapter5_5();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[] num =  new int[a];
        for(int i=0; i<a; i++){
            num[i] = in.nextInt();
        }
        System.out.println(T.solution(a,b,num));
        in.close();
    }
}

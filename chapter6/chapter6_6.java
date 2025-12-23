package chapter6;
import java.util.*;

public class chapter6_6 {
    /* 재밌는 사실: 스텍은 클래스고 큐는 인터페이스다 (스텍이 만들어지고 스텍처럼 큐도 필요해 보여서
                    인터페이스로 만들었다고 한다) 
        개선 1. 값을 빼고 다시 넣을 때 Q.offer(Q.poll()) 사용
        */
    public int solution(int a, int b){
        int answer = 0;
        Queue <Integer> Q = new LinkedList<>();
        for(int i=1; i<a+1; i++ ){
            Q.offer(i);
        }
        while(!Q.isEmpty()){
            for(int j =0; j<b-1; j++ ) Q.offer(Q.poll());
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }
        
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_6 T = new chapter6_6();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(T.solution(a,b));
        in.close();
    }
}

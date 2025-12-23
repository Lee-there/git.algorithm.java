package chapter6;
import java.util.*;
public class chapter6_7 {
    /* 개선1. B.poll이랑 A.peek비교할 때 가급적이면 == 대신 equals사용
              ㄴ> ==는 주소값도 비교하기 때문에 int 나 char은 == 사용해도 되지만 
                  String이나 Integer, 큐에서 나온 객체들(ex: poll값) 은 무조건 equal
        강의 풀이: 필수교양(a)만 스텍으로 만든 후 for문을 통해 수업들(b)중 a와 수업이 동일한게 있을 때  
        그 수업이 A의 poll과 같으면 진행 틀리면 바로 break 끝에 A가 비어있으면 Yes 아니면 no       
         */
    public String solution(String a, String b){
        String answer = "NO";
        Queue<Character> A = new LinkedList<>();
        Queue<Character> B = new LinkedList<>();
        for(char x : a.toCharArray()) A.offer(x);
        for(char x : b.toCharArray()) B.offer(x);
        while( !B.isEmpty()){
            if(B.poll().equals(A.peek())) {
                A.poll();
            }

            if( A.isEmpty()) return "YES";
        }


        return answer;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_7 T = new chapter6_7();
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(T.solution(a,b));
        in.close();
    }
}

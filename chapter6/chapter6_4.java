package chapter6;
import java.util.*;

public class chapter6_4 {
    /* 1.후위연산시기 할 때 스텍으로 정수형으로 만들고 문자 나오면 넣지 말고 
          2개 pop 후 계산 결과 push
        2. isDigit 사용하기 (char이 0~9 이면 true 나머지 false)
        3.편의를 위해 아스키코드 48번이 0인거 알아놓기
    */
    public int solution(String a){
        Stack<Integer> stack = new Stack<>();
        for(char x : a.toCharArray()){
            if(Character.isDigit(x) ) stack.push(x-48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                stack.push(switch(x) {
                    case '+' -> lt+rt;
                    case '-' -> lt-rt;
                    case '*' -> lt*rt;
                    case '/' -> lt/rt;
                    default -> 0;
                });
            }
        }
        int answer = stack.get(0);
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_4 T = new chapter6_4();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
        in.close();
    }
    
}

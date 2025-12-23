package chapter6;
import java.util.*;

public class chapter6_1 {
    // 괄호 문제 나올 경우 스텍을 쓸 확률이 높음
    public String solution( String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x == '(') stack.push(x);
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO"; 
        return answer;
    }


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_1 T = new chapter6_1();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
        in.close();
    }
    
}

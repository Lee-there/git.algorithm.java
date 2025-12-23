package chapter6;

import java.util.*;



public class chapter6_2 {

    public String solution(String str){
        /* 
        1.강의 같은 경우 stack에 다 넣고 ) 나왔을 때 (가 pop 되는 
        경우까지 계속 pop 진행.
        2. pop같은 경우 pop() == 문자를 통해 pop한 문자가 뭔지 확인 가능
        */
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x == '(') stack.add(x);
            if(stack.empty()) answer += x;
            if(x == ')') stack.pop();
        }
        return answer;

    }

    @SuppressWarnings("ConvertToTryWithResources")

    public static void main(String[] args) {
        chapter6_2 T = new chapter6_2();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
        in.close();

    }
}

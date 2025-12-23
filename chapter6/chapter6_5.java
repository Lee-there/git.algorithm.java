package chapter6;
import java.util.*;
public class chapter6_5 {
    /* 굳이 for(char x : str.toCharArray) 사용 안해도 됨 상황에 맞게
        어떨 때는  for(int i = 0; i<str.length(); i++) 사용해야됨
        ** 개인적인 생각** 
        for(char x : str.toCharArray)로 stack 사용 시 전 index값이 pop돼서 
        확인하기 어려움 그럴 때는 for(int i = 0; i<str.length(); i++)
        결론: 전 인덱스 확인해야 되는 문제는 for(int i = 0; i<str.length(); i++)로
        */
    public int solution(String str){
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_5 T = new chapter6_5();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
        in.close();
    }
    
}

package chapter5;
import java.util.*;

public class chapter5_2 {
    /* 내 풀이같은 경우 HashMap 2개를 만들어 둘을 equals (만약 둘을 ==로 비교 시 HashMap의 주소값 비교가 되어버림)
       로 비교했으며 
       강의 같은 경우 첫 문자열을 HashMap으로 만든 후 다음 문자열을 통해 위의 HashMap의 Value를
       하나씩 줄이는 방법으로 풀이함 둘 다 상관없음 */
    public String solution(String a , String b){
        String answer = "YES" ;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x:a.toCharArray()){
            map.put(x, map.getOrDefault(x, 0 ) + 1 );
        }
        for(char x:b.toCharArray()){
           if(!map.containsKey(x) || map.get(x) == 0) return "NO";
           map.put(x, map.get(x)-1);
        }
        
        return answer;
    }
    

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter5_2 T = new chapter5_2();
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        System.out.println(T.solution(str1, str2));
        in.close();
    }


}

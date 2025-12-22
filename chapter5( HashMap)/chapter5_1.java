import java.util.*;

public class chapter5_1{
    /* 복습
        1. HashMap에는 키와 벨류 존재함
        2. getOrDefault(Key의 벨류 아니면 새로 key와 벨류 추가), 
        containsKey(key 들어있는지 확인 불린형으로), 
        size(키의 종류 개수 확인)  remove(키 삭제) <- 만약 remove('C') 하면 C의 벨류 출력 후 C삭제
    */

     public char solution(int n, String s){
            char answer = ' ';
            HashMap<Character, Integer> map = new HashMap<>();
            for(char x : s.toCharArray()){
                map.put(x, map.getOrDefault(x,0)+1);
            }
            int max = Integer.MIN_VALUE;
            for(char x : map.keySet()){
                if(map.get(x)>max){
                    max = map.get(x);
                    answer = x;
                }
            }
            return answer;
        }
   

     @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter5_1 T = new chapter5_1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(T.solution(n,str));
        in.close();
    }
    
}
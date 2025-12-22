import java.util.*;

public class chapter5_4 {
   
    public int solution(String a , String b){
        // 강의 영상 듣고 다음 넘어가기
        int answer = 0;
        HashMap<Character , Integer>  map1 = new HashMap<>(); // 짧은 문자열
        HashMap<Character , Integer>  map2 = new HashMap<>(); // 확인 문자열
        for(char x : b.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0) +1);
        }
        int lt = 0;
        char[] str = a.toCharArray();
        for(int i=0; i<b.length() -1; i++){
             map2.put(str[i], map2.getOrDefault(str[i], 0) +1);
        }
        
        for(int rt = b.length() -1; rt < a.length(); rt++ ){
            map2.put(str[rt] , map2.getOrDefault(str[rt], 0) +1 );
            if(map1.equals(map2)) answer++;
            map2.put(str[lt], map2. get(str[lt]) -1);
            if(map2.get(str[lt]) == 0) map2.remove(str[lt]);
            lt++;
        }




        return answer;
    }




    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter5_4 T = new chapter5_4();
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        System.out.print(T.solution(str1 , str2));
        in.close();
    }
    
}


import java.util.*;

public class chapter5_3 {
    // 투포인터랑 슬라이딩윈도우 사용
    public ArrayList<Integer> solution(int a, int b, int[] num){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<b-1; i++){
            map.put(num[i], map.getOrDefault(num[i], 0)+1);
        }
        int lt = 0;
        for(int rt = b-1; rt<a; rt++){
            map.put(num[rt], map.getOrDefault(num[rt],0) +1);
            answer.add(map.size());
            if(map.get(num[lt]) == 1) map.remove(num[lt++]);
            else map.put(num[lt], map.get(num[lt++] ) -1 );
        }

        return answer;
    }


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter5_3 T = new chapter5_3();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[] num = new int[a];
        for (int idx = 0; idx < num.length; idx++) {
            num[idx] = in.nextInt(); 
        }
        for(int x: T.solution(a,b,num)){
            System.out.print(x + " ");
        } 
        in.close();
    }
}


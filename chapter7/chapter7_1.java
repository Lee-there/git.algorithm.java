package chapter7;
import java.util.*;

public class chapter7_1{
    // 선택정렬 알고리즘 
    public int[] solution(int a , int[] num){
        for(int i=0; i< a-1; i++){
            int idx = i;
            for(int j=i+1; j<a; j++){
                if(num[idx] > num[j]) idx = j;
            }
            int tmp = num[i];
            num[i] = num[idx];
            num[idx] = tmp;
        
    }
    return num;
}
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_1 T = new chapter7_1();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] num = new int[a];
        for(int i=0; i<a; i++){
            num[i] = in.nextInt();
        }
        for(int x : T.solution(a,num)){
            System.out.print(x + " ");
        }
        in.close();
    }



}
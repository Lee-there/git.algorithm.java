package chapter7;
import java.util.*;

public class chapter7_5{
    //간단한 중복 확인
    public String solution(int n, int[] arr){
        String answer = "U";
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_5 T = new chapter7_5();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = in.nextInt();
        System.out.println(T.solution(n,arr));
        in.close();
    }
}
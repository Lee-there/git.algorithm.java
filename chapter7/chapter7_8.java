package chapter7;
import java.util.*;

public class chapter7_8{
    //이중검색
    public int solution(int n , int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0,  rt = n-1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == m){
                answer = mid + 1; // 이 부분 실수 나올 확률 있음
                break;
            }
            if(arr[mid]>m) rt = mid-1;
            else lt = mid + 1;
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_8 T = new chapter7_8();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = in.nextInt();
        System.out.println(T.solution(n,m,arr)); 
        in.close();
    }
    
}
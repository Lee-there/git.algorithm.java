package chapter7;
import java.util.*;

public class chapter7_9{
    /*결정 알고리즘
        이중 검색을 통해 최선의 답 찾기
     */
    public int count(int[] arr, int c){
        int cnt = 1;
        int sum = 0;
        for(int x : arr){
            if(sum+x > c){
                cnt++;
                sum = x;
            }
            else sum+= x;
        }
        return cnt;
    }
    
    public int solution(int n, int m, int[] arr){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)<=m){
                answer = mid;
                rt = mid-1;
            }else lt = mid+1;
        }

        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_9 T = new chapter7_9();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = in.nextInt();
        System.out.println(T.solution(n,m,arr));
        in.close();
    }
}
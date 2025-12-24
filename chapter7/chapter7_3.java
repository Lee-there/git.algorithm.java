package chapter7;
import java.util.*;


public class chapter7_3{
    // 삽입정렬 : 복습필요
    public int[] solution(int a, int[] arr){
        for(int i=1; i<a;i++){
            int tmp = arr[i], j;
            for( j= i-1; j>=0; j--){
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        chapter7_3 T = new chapter7_3();
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int[] arr = new int[a];
        for(int i=0; i<a; i++){
            arr[i] = in.nextInt();
        }
        for(int x : T.solution(a,arr)){
            System.out.print(x + " ");
        }
    }


    
}
package chapter7;
import java.util.*;

public class chapter7_2{
    // 버블정렬 : 복습 필요
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] solution(int a , int[] arr){
        for(int i=0; i<a-1; i++){
            for(int j=0; j<a-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
          return arr;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_2 T = new chapter7_2();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        for(int i=0; i<a; i++){
            arr[i] = in.nextInt();
        }
        for(int x : T.solution(a,arr)){
            System.out.print(x + " ");
        }
        in.close();
    }



}
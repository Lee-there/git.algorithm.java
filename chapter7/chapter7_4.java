package chapter7;
import java.util.*;

public class chapter7_4{
//LRU(Least Recently Used) 
static int s,n;
static int[] arr;
    public int[] solution(){
        int[] CPU = new int[s];
        for(int x : arr){
            int pos = -1;
            for(int i=0; i<s; i++) if(x == CPU[i]) pos = i;
            if(pos == -1){
                for(int i=s-1; i>=1; i--){
                    CPU[i] = CPU[i-1];
                }
            }else{
                for(int i=pos; i>=1; i--){
                    CPU[i] = CPU[i-1];
                }
            }
            CPU[0] = x;
        }

        return CPU;
    }
@SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter7_4 T = new chapter7_4();
        Scanner in = new Scanner(System.in);
        s = in.nextInt();
        n = in.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        for(int x : T.solution()) System.out.print(x + " ");
        in.close();

    }
}

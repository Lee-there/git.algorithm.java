package chapter8;
import java.util.*;

public class chapter8_3 {
    //팩토리얼
        public int DFS(int n){
            if(n==1) return 1;
            else return n*DFS(n-1);

        }
    public static void main(String[] args) {
        chapter8_3 T = new chapter8_3();
            try (Scanner in = new Scanner(System.in)) {
                int n = in.nextInt();
                System.out.println(T.DFS(n));
            }
    }
}

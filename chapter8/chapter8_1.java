package chapter8;

public class chapter8_1 {
    // 재귀함수(stack 프레임으로 쌓임)
    @SuppressWarnings("UnnecessaryReturnStatement")
    public void DFS(int n){
        if( n==0) return;
        else{
        System.out.println(n);
        DFS(n-1);
        System.out.print(n + " ");
        }
    }
    public static void main(String[] args) {
        chapter8_1 T =new chapter8_1();
        T.DFS(3);
    }
}

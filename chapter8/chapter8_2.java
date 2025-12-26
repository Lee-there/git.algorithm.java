package chapter8;

public class chapter8_2 {
    /* 스텍 구조를 생각하면서 코드 짜기 (항상 재귀 진행 시 재귀 밑의 코드는 스텍 순서로 진행) 
    -> 스텍 구조를 이해하면 System.out.print(n%2 + " "); 의 위치가 DFS(n/2);의 위인지에 
    따라 출력이 완전히 바뀐다는 것 알 수 있음  */
    @SuppressWarnings("UnnecessaryReturnStatement")
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }
   public static void main(String[] args) {
     chapter8_2 T = new chapter8_2();
    T.DFS(11);
    
   }
   
    
}

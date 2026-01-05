package chapter9;


// 중복 순열 공부 후 다시 도전해보기
public class chapter9_5 {

}

/*  내가 만들었던 코드
1. 
  static int[] arr;
    static int cost;
    public int BFS(int n){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int v = Q.poll();
                for(int j=0; j<n; j++){
                    if(v+arr[j] == cost) return L+1;
                    if(v+arr[j]<cost){
                    Q.offer(v+arr[j]);
                    }
                }
            }
            L++;
        }
        return L;
    }  */

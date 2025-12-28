package chapter8;
import java.util.*;


public class chapter8_8 {
    /* 
    1. BFS문제라고 꼭 재귀함수를 사용할 필요 없음
    2. 큐 사용 방법 숙지 
    3. dis배열처럼 이동할 때 배열과 for문을 사용해서 이동하는 방식 유용함
    4. 움직일 때 변수를 바꾸는 방법보다 배열에서 변수가 이동한 위치를 인덱스로 해서
       그 인덱스의 값을 1로 바꾸는 방법 많이 사용하는듯 */
    
    int[] dis = {-1 , 1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx = x+ dis[j];
                    if(nx == e) return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx] == 0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter8_8 T = new chapter8_8();
        Scanner in = new Scanner(System.in);
        int srt = in.nextInt();
        int fin = in.nextInt();
        System.out.print(T.BFS(srt,fin));    
        in.close();
    }

    

}


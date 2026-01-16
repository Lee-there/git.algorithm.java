import java.util.*;

class BFS2606{
    static int n,m;
    static int answer = 0;
    static int[][] arr;
    static boolean[] ch;
    public void BFS(int s){
        ch[s] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=1; i<=n; i++){
            if(arr[tmp][i] == 1 && ch[i] == false){
                Q.offer(i);
                answer++;
                ch[i] = true;
            }
        }
        }
        

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS2606 T = new BFS2606();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점
        m = in.nextInt(); // 간선
        ch = new boolean[n+1];
        arr = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            arr[p][q] = 1;
            arr[q][p] = 1;
        }
        T.BFS(1);
        System.out.println(answer);
        in.close();
    }
}
/*
보완할 점
1. 컴퓨터 수(N) 이 증가하는 경우 배열은 시간 복잡도 올라감
-> 인접 행렬 사용하기(더 효율적)

만약 answer++을 poll()할 때 추가해주고 싶으면 
while (!Q.isEmpty()) {
    int tmp = Q.poll();
    if (tmp != s) {
        answer++;
    }
    for (int i = 1; i <= n; i++) {
        if (arr[tmp][i] == 1 && !ch[i]) {
            ch[i] = true;
            Q.offer(i);
        }
    }
} 
이 방법이나 answer 초기값을 -1로 하면 가능함*/
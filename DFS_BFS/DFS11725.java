import java.util.*;

class DFS11725{
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    static int[] ans;
    public void DFS(int s){
        for(int x : A.get(s)){
            if(!ch[x]){
                ans[x] = s;
                ch[x] = true;
                DFS(x);
            }
        }
    }
    public void BFS(int s){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int x : A.get(tmp)){
                if(!ch[x]){
                    ans[x] = tmp;
                    ch[x] = true;
                    Q.offer(x);
                }
            }
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        DFS11725 T = new DFS11725();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ch = new boolean[n+1];
        ch[1] = true;
        ans = new int[n+1];
        for(int i=0; i<=n; i++){
            A.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            int p = in.nextInt();
            int q = in.nextInt();
            A.get(p).add(q);
            A.get(q).add(p);
        }
        //T.DFS(1); 
        T.BFS(1);
       for(int i=2; i<=n; i++){
            System.out.println(ans[i]);
        }
        in.close();
    }
}
/*
개선 1.처음에 문제를 DFS로 풀었는데 이 경우 트리가 너무 길게 연결되어 StackOverfloseError 뜨게 됨
       -> BFS로 다시 풀어보기*/
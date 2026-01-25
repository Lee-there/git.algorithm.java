package chapter10;
import java.util.*;
 
class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class chapter10_7 {
    //최소스패닝트리: 크루스칼, Union&Find 활용
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1];
        ArrayList<Edge> arr = new ArrayList<>();
        for(int i=1; i<n; i++) unf[i] = i;
        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            arr.add(new Edge(a,b,c));    
        }
        int answer = 0;
        Collections.sort(arr);
        for(Edge o : arr){
            int fv1 = Find(o.v1);
            int fv2 = Find(o.v2);
            if(fv1 != fv2){
                answer += o.cost;
                Union(o.v1, o.v2);
            }
        }

        System.out.println(answer);
        in.close();
    }
}
/*
fv1이랑 fv2라는 두 정수형을 비교함으로서 둘이 연결되어있는지 확인 후
연결 안되어있을 경우 연결해주고 Union을 통해 하나로 묶음 */
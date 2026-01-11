package chapter9;
import java.util.*;

public class chapter9_15 {
    static int n,m, len, answer = Integer.MAX_VALUE;
    static int[][] board;
    static int[] combi;
    static ArrayList<Point> pd, hd;
    public void DFS(int L, int s){
        if(L == m){
            int sum = 0;
            for(Point h : hd){
                int dis = Integer.MAX_VALUE;
                for(int i: combi){
                    dis = Math.min(dis, Math.abs(h.x- pd.get(i).x) + Math.abs(h.y-pd.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }

    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter9_15 T = new chapter9_15();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][n];
        pd = new ArrayList<>();
        hd = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = in.nextInt();
                if(board[i][j] == 1) hd.add(new Point(i,j));
                else if(board[i][j] == 2) pd.add(new Point(i,j));
            }
        }
        len = pd.size();
        combi = new int[m];
        T.DFS(0,0);
        System.out.println(answer);
        in.close();
    }
}

/* 내 코드
public class chapter9_15 {
    static int n,m, len, answer = Integer.MAX_VALUE;
    static int[][] board;
    static int[] combi;
    static ArrayList<Point> pd, hd;
    public void DFS(int L, int s){
        if(L == m){
            int sum = 0;
            for(int i=0; i<hd.size(); i++){
                int min = Integer.MAX_VALUE;
                Point tmph = hd.get(i);
                int hx = tmph.x;
                int hy = tmph.y;
                for(int j=0; j<m; j++){
                    Point tmpp = pd.get(combi[j]);
                    int px = tmpp.x;
                    int py = tmpp.y;
                    int dis = Math.abs(px-hx) + Math.abs(py-hy);
                    min = Math.min(min, dis);
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
        }else{
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }

    }
}
이번 문제는 조합 DFS를 만들줄 몰라서 조합DFS 만드는 과정까지 듣고 다시 혼자 풀어봄
if(L==m) 안쪽을 내가 품
개선 1. board배열은 이미 hd랑 pd 만든 순간부터 필요 없는 배열임
개선 2. 조합 DFS 자유자제로 사용할 수 있도록 숙지하기
개선 3. 내 코드는 뭔가 굉장히 투박함
       개선3.1 향상된 for문 사용하기(ArrayList에서 매번 꺼낼 시 느려짐)
       개선3.2 int px = tmpp.x;와 같은 변수 선언은 코드를 좀 더 길고 복잡하게 만든다
       개선3.3 네이버 내게쓰기 확인
 */
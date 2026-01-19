import java.util.*;
class BFS1987{
static int n,m;
static char[][] arr;
static boolean[] ch;
static int[] dx = {0,1,0,-1};
static int[] dy = {1,0,-1,0};
static int max = 1;
static ArrayList<Character> Q = new ArrayList<>();
    public void DFS(int x, int y){
        Q.add(arr[x][y]);
        max = Math.max(max,Q.size()); 
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m ){
                int C = arr[nx][ny] - 'A';
               if(!ch[C]){
                ch[C] = true;
                DFS(nx,ny);
                ch[C] = false;
               }
            }
        }
       Q.remove(Q.size() - 1); 
    }
@SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS1987 T = new BFS1987();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new char[n][m];
        ch = new boolean[26];
        for(int i=0; i<n; i++){
            String A = in.next();
            for(int j=0; j<m; j++){
                arr[i][j] = A.charAt(j);
            }   
        }
        ch[arr[0][0]-'A'] = true;
        T.DFS(0,0);
        System.out.println(max);
        in.close();
    }
}

/* 내가 틀렸던 코드
import java.util.*;
class BFS1987{
static int n,m;
static char[][] arr;
static boolean[] ch;
static int[] dx = {0,1,0,-1};
static int[] dy = {1,0,-1,0};
static int max = 1;
static ArrayList<Character> Q = new ArrayList<>();
    public void DFS(int x, int y){
        Q.add(arr[x][y]);
        boolean change = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int C = arr[nx][ny] - 'A';
            if(nx>=0 && nx<n && ny>=0 && ny<m && !ch[C]){ //바뀜
                change = false;
                ch[C] = true;
                DFS(nx,ny);
                Q.remove(Q.size()-1); // 바뀜
                ch[C] = false;
            }
        }
        if(change) max = Math.max(max,Q.size());  //바뀜
    }
@SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        BFS1987 T = new BFS1987();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new char[n][m];
        ch = new boolean[26];
        for(int i=0; i<n; i++){
            String A = in.next();
            for(int j=0; j<m; j++){
                arr[i][j] = A.charAt(j);
            }   
        }
        ch[arr[0][0]-'A'] = true;
        T.DFS(0,0);
        System.out.println(max);
        in.close();
    }
}
    



*/
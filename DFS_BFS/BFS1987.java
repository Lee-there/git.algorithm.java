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

/* 
개선1. DFS는 항상 접근 -> 갱신 -> 탐색 -> 퇴출(원복) 의 과정을 거쳐야 된다 
       -> 코드 짜면서 이 원복 과정이 없어서 큰 문제가 생김
// [비포]
public void DFS(int x, int y) {
    Q.add(arr[x][y]); // (1) 일단 넣음
    for(...) {
        if(nx, ny 갈 수 있으면) {
            DFS(nx, ny);
            Q.remove(Q.size()-1); // (2) 다음 칸이 있을 때만 지움 (위험!)
        }
    }
}
// [애프터]
public void DFS(int x, int y) {
    Q.add(arr[x][y]); // (1) 내(x, y) 알파벳 추가
    for(...) {
        if(nx, ny 갈 수 있으면) {
            ch[C] = true;
            DFS(nx, ny);
            ch[C] = false;
        }
    }
    Q.remove(Q.size() - 1); // (2) 함수 끝나기 직전 내 것 삭제 (항상 실행됨)
}

개선2. DFS 내에서 리스트 생성 시 DFS 실행될때마다 초기화돼서 문제 생김 (전역 변수 사용하자)


개선3. 방문 체크인 ch와 리스트의 추가 불일치
      -> 방문 체크는 알파벳 중복을 체크하는데  리스트는 경로를 기록하여 이 불일치로 인해 코드 망함
개선4. int C = arr[nx][ny] 부분이 위험함 (ArrayIndexOutOfBoundsException 가능)
비포 (위험): int C = arr[nx][ny] - 'A';를 먼저 하고 나서 nx 범위를 체크함.
            -> nx가 -1이라면 arr[-1]에 접근하는 순간 에러가 나며 프로그램이 종료됨.
애프터 (안전): if(nx >= 0 ...) 같은 범위 체크를 먼저 하고, 그 안에서 arr[nx][ny] 값을 가져옴.

개선5. max 갱신 로직 타이밍 아쉬움 (boolean change를 통한 조건문은 복잡하고 조건이 까다로움)
       -> 그냥 Q.add 하자마자 계속 갱신

내가 틀렸던 코드
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
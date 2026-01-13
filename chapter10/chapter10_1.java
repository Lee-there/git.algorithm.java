package chapter10;
import java.util.*;
class Point implements Comparable<Point>{
    //chapter7-7 참고
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        return o.x - this.x;
    }
}
public class chapter10_1 {
    public int solution(ArrayList<Point> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr.get(i).y > max){
                cnt++;
                max = arr.get(i).y;
            }
        }  

        return cnt;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter10_1 T = new chapter10_1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x,y));
        }
        System.out.println(T.solution(arr, n));
        in.close();
    }
}
/* greedy알고리즘 
    키 순으로 정렬 후 키 가장 큰 사람의 몸무게 Max로 설정 후 
    Max 최신화 될 때마다 cnt++
 */
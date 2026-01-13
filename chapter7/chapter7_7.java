package chapter7;
import java.util.*;
class Point implements Comparable<Point>{
    /* Comparable객체 
        CompareTo의 리턴값을 통해 순서 결정
        음수: this가 비교대상(o)보다 작으므로 앞으로 이동 -> this.x - o.y(오름차순)
        양수: this가 비교대상(o)보다 크므로 뒤로 이동 -> o.x - this.x(내림차순)
        주의할 점: 두 수의 차이가 너무 크면 Overflow 생기니까 return Integer.compare() 사용하기
        */
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y - o.y;
        else return this.x-o.x;
    }
}
public class chapter7_7{
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
        in.close();
    }
}
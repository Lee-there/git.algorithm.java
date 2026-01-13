package chapter10;
import java.util.*;

class Time implements Comparable<Time>{
    public int s, e;
    Time(int x, int y){
        this.s = x;
        this.e = y;
    }
    @Override
    public int compareTo(Time o){
        if(this.e==o.e) return this.s - o.s;
        else return this.e-o.e;
    }
}
public class chapter10_2 {
    public int solution(ArrayList<Time> arr , int n){
        int cnt=0;
        Collections.sort(arr);
        int et = 0;
        for(Time x : arr){
           if(x.s>=et){
            cnt++;
            et = x.e;
           } 
        }
        return cnt;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter10_2 T = new chapter10_2();
        Scanner in = new Scanner(System.in);
        ArrayList<Time> arr = new ArrayList<>();
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int s = in.nextInt();
            int e = in.nextInt();
            arr.add(new Time(s,e));
        }
        System.out.println(T.solution(arr,n));
        in.close();
    }
}
/* 회의실 배정 문제
    솔직히 그냥 어떻게 풀어야될 지 몰라서 풀이 듣고도 강의 보면서 코드 작성함
    느낀점 :사실상 제공받은 자료들을 어떻게 잘 정렬해서 순서대로 보느냐가 정말 중요한 듯 
            솔직히 지금 이 정렬 방식이 왜 예외 없이 최선의 방법인지 감이 안잡힘(반례 있을거 같아서 찝찝함)
    이번 문제는 회의 끝나는 시간 기준으로 오름차순 후 끝나는 시간 동일 시 시작 시간 오름차순 순으로 정렬
    이렇게 정렬만 잘 해놓으면 그 다음부터 코드는 쉬운 
    (자료를 어떻게 정렬해 놓을 것이며 그 정렬을 통해 어떤 방법으로 문제 해결해 나갈지가 중요)
     -> 솔직히 그냥 이건 많이 풀어보면서 유형 익혀야될듯*/
package chapter10;
import java.util.*;
class Time implements Comparable<Time>{
    public int time; 
    public char state;
    Time(int time , char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o){
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
public class chapter10_3 {
    public int solution(ArrayList<Time> arr){
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Time o : arr){
            if(o.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
 public static void main(String[] args) {
    chapter10_3 T = new chapter10_3();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<Time> arr = new ArrayList<>();
    for(int i=0; i<n; i++){
        int s = in.nextInt();
        int e = in.nextInt();
        arr.add(new Time(s, 's'));
        arr.add(new Time(e, 'e'));
    }
    System.out.println(T.solution(arr));
    in.close();
 }   
}
/* 겹치는 최대 인원 수 찾는 문제
굳이 들어온 시간과 나가는 시간을 짝으로 받는다고 자료를 짝으로 받을 필요 X (대신 다른 방법으로 분류)
그냥 이 알고리즘은 제공되는 자료들을 어떻게 잘 분류 정렬하는지가 젤 중요한듯 
**greedy 알고리즘은 일단 많이 풀어보자**(감 익혀야 될듯)
 */
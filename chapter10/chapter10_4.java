package chapter10;
import java.util.*;
//Priority Queue사용법
class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time){
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture ob){
        return ob.time-this.time; // 내림차순
    }
}
public class chapter10_4 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 작은 것부터
        Collections.sort(arr);
        int j = 0;
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                if(arr.get(j).time<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter10_4 T = new chapter10_4();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int m = in.nextInt();
            int d = in.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d;
        }
        System.out.println(T.solution(arr));
        in.close();
    }
}

/* 
복습1. PriorityQueue는 원래 작은 값부터 꺼내주지만 Collections.reverseOrder하면 
       큰 값부터 꺼내준다 
복습2. 자바의 for(초기화식; 조건식; 증감식) 구조에서 초기화식은 생략이 가능하다
        for문에서 변수를 for문 밖으로 빼면 j의 값이 유지돼서 다음 for문 진행할 때 저장된 j 값부터 시작함
        int j = 0;
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                if(arr.get(j).time<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        이러면 break 이후 다시 for문 시작시 전 for문 끝난 시점의 j부터 시작
        -> j=3일 때 break 됐다면 다시 for문 시작 시 j=3부터 시작*/
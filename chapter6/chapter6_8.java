package chapter6;
import java.util.*;

class Person{
    int id;
    int priority;
public Person(int id, int priority){
    this.id = id;
    this.priority = priority;
    }
}

public class chapter6_8 {
    //클래스 구현하는 거 좀 더 연습하기 
    // 논리 구조 천천히 내려가면서 한 번 더 정리하기
    public int solution(int n , int m, int[] arr){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.add(new Person(i,arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp = Q.poll();
            for(Person x: Q){
                if(x.priority>tmp.priority){
                    Q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == m ) return answer;
            }
        }
        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_8 T = new chapter6_8();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int [] num = new int[a];
        for(int i=0; i<a; i++){
            num[i] = in.nextInt();
        }
        System.out.println(T.solution(a,b,num));
        in.close();
    }
    
}


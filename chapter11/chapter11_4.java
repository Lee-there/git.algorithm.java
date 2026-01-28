package chapter11;
import java.util.*;

class Block implements Comparable<Block>{
        int area;
        int height;
        int weight;
        Block(int area, int height, int weight){
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Block o){
            return o.area - this.area;
        }

    }

public class chapter11_4 {
    static int n;
    static ArrayList<Block> arr;
    static int[] dy;
    public void solution(){
        dy[0] = arr.get(0).height;
        int answer = dy[0];
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(arr.get(j).weight > arr.get(i).weight && max < dy[j]) max = dy[j];
            }
            dy[i] = max + arr.get(i).height;
            answer = Math.max(answer , dy[i]);
        }
        System.out.println(answer);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter11_4 T = new chapter11_4();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dy = new int[n];
        arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            arr.add(new Block(a,b,c));
        }
        Collections.sort(arr);
        T.solution();
        in.close();
    }
}
/* 혼자 아이디어 생각나서 풀었다 개꿀
    복습1. 처음에 풀 때 살짝 착각해서 if문을  arr.get(j).weight < arr.get(i).weight로 한 것 말고는
    복습할 것 없을듯
 */

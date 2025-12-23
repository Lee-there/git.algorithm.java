package chapter6;

import java.util.*;

public class chapter6_3 {
    /* 실수 1. moves값에 -1 해줘야 오류 안생김 (index는 항상 0부터)
       실수 2. break문 사용 안해서 한 줄에 있는 인형 한번에 다 뽑아버림 (break를 통해 하나만 뽑도록 제어했어야 함)
       개선 1. for문 사용할 때 for(int pos: moves) 사용하면 좀 더 깔끔한 코드 가능
       1.peek를 통해 stack 맨 윗 값 확인 가능
    */ 
    public int solution(int a, int[][] board, int b, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<b; i++){
            for(int j=0; j<a; j++){
                if(board[j][moves[i] -1 ] != 0)  {
                    if( !stack.isEmpty() && board[j][moves[i] -1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(board[j][moves[i] -1]);

                    board[j][moves[i] -1 ] = 0;
                    break;
                }
            }
        }       
        

        return answer;
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        chapter6_3 T = new chapter6_3();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[][] board = new int[a][a];
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                board[i][j] = in.nextInt();
            }
        }
        int b = in.nextInt();
        int[] moves = new int[b];
        for(int i=0; i<b; i++){
            moves[i] = in.nextInt();
    }
    System.out.println(T.solution(a, board, b, moves));
    in.close();
    }
    
}


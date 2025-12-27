package chapter8;

import java.util.*;

  class Node{
        int data;
        Node rt, lt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }

public class chapter8_7 {
    /* 레벨탐색 ( 맨 위에서 밑으로 N번 내려가야 존재하는 요소들을 다 정리하는 탐색)
        이 자료구조를 통해 최단거리 구할 수 있음 (레벨이 제일 낮은 곳에 있는 놈이 아마 최단거리가 되지 않을까 예상)
     */
   Node root;
   public void BFS(Node root){
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int L = 0;
    while(!Q.isEmpty()){
        int len = Q.size();
        System.out.print(L+" : ");
        for(int i=0; i<len; i++){
            Node cur = Q.poll();
            System.out.print(cur.data+ " ");
            if(cur.lt != null) Q.offer(cur.lt);
            if(cur.rt != null) Q.offer(cur.rt);
        }
        L++;
        System.out.println();
    }

   }


    public static void main(String[] args) {
        chapter8_7 tree = new chapter8_7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}

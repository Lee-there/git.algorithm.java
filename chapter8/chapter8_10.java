package chapter8;

import java.util.*;

// 트리 말단노드까지의 최단거리(BFS로)

public class chapter8_10 {
    Node root;
    int BFS(Node root){
        int L = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            int a = Q.size();
            for(int i=0; i<a;i++){
                Node tmp = Q.poll();
                if(tmp.lt == null && tmp.rt == null) return L;
                if(tmp.lt != null) Q.offer(tmp.lt);
                if(tmp.rt != null) Q.offer(tmp.rt);
            
            }
            L++;

        }

        return 0;
    }
    public static void main(String[] args) {
        chapter8_10 tree = new chapter8_10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}

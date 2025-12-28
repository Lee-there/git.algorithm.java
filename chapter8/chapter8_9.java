package chapter8;

class Node{
        int data;
        Node lt, rt;
        Node(int val){
            data = val;
            lt = rt = null;
        }
        
    }

public class chapter8_9 {
    Node root;
    public int BFS(Node root){
        int L = 0;



        return L;
    }
    public static void main(String[] args) {
        chapter8_9 tree = new chapter8_9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }

   
}

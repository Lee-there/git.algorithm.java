package chapter8;
// 트리 말단노드까지의 최단거리(DFS로) 


public class chapter8_9 {
    Node root;
     int DFS(int L, Node root){
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1,root.lt), DFS(L+1, root.rt));
    }
    public static void main(String[] args) {
        chapter8_9 tree = new chapter8_9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}

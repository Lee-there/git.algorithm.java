package chapter8;

/* 이진트리
        1.전위순회: 부모 -> 왼쪽 자식 -> 오른쪽 자식
        2.중위순회: 왼쪽 자식 -> 부모 -> 오른쪽 자식
        3.후위순회: 왼쪽 자식 -> 오른쪽 자식 -> 부모   */


public class chapter8_5 {
    /*밑의 1번 코드 2번 코드 3번 코드를 어디에 하냐에 따라 전위 중위 후위 순회로 구분된다
        전위: 1->2->3
        중위: 2->1->3
        후위: 2->3->1                                                            */
    Node root;
    @SuppressWarnings("UnnecessaryReturnStatement")
    public void DFS(Node root){
        if(root == null) return;
        else{ 
            System.out.print(root.data+" "); // 1번 코드
            DFS(root.lt); // 2번 코드
            DFS(root.rt); // 3번 코드
        }
    }



    public static void main(String[] args) {
        chapter8_5 tree = new chapter8_5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);

    }
}

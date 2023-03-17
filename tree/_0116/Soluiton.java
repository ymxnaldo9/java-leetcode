package tree._0116;

public class Soluiton {
    public Node connect(Node root) {
        if (root == null)
            return root;
        traverse(root.left, root.right);
        return root;
    }
    public void traverse(Node n1, Node n2){
        if (n1 == null || n2 == null)
            return;
        n1.next = n2;
        traverse(n1.left, n1.right);
        traverse(n2.left, n2.right);
        traverse(n1.right, n2.left);
    }
}
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }
    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

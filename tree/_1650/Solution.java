package tree._1650;

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b){
            if (a == null)
                a = q;
            else
                a = a.parent;
            if (b == null)
                b = p;
            else
                b = b.parent;
        }
        return a;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
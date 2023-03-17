package tree._1644;

public class Solution {
    boolean foundp = false;
    boolean foundq = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p.val, q.val);
        if (!foundp || !foundq)
            return null;
        return res;
    }
    public TreeNode find(TreeNode root, int val1, int val2){
        if (root == null)
            return null;
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        if (left != null && right != null)
            return root;
        if (root.val == val1 || root.val == val2){
            if (root.val == val1)
                foundp = true;
            if (root.val == val2)
                foundq = true;
            return root;
        }
        return left != null ? left : right;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
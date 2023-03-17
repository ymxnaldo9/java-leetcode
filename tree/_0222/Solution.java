package tree._0222;

public class Solution {
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int hl = 0;
        int hr = 0;
        while (l != null){
            l = l.left;
            hl++;
        }
        while (r != null){
            r = r.right;
            hr++;
        }
        if (hl == hr)
            return (int)Math.pow(2, hl) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
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
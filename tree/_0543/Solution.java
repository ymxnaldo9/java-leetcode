package tree._0543;

public class Solution {
    int maxdiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxdepth(root);
        return maxdiameter;
    }
    private int maxdepth(TreeNode root){
        if (root == null)
            return 0;
        int left = maxdepth(root.left);
        int right = maxdepth(root.right);
        maxdiameter = Math.max(maxdiameter, left + right);
        return Math.max(left, right) + 1;
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
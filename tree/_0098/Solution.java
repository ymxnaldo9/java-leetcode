package tree._0098;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isvalid(root, null, null);
    }
    public boolean isvalid(TreeNode root, TreeNode min, TreeNode max){
        if (root == null)
            return true;
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return isvalid(root.left, min, root) && isvalid(root.right, root, max);
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
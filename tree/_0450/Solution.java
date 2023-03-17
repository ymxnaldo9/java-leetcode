package tree._0450;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key){
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode minnode = getmin(root.right);
            root.right = deleteNode(root.right, minnode.val);
            minnode.left = root.left;
            minnode.right = root.right;
            root = minnode;
        }
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        return root;
    }
    private TreeNode getmin(TreeNode root){
        while (root.left != null)
            root = root.left;
        return root;
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
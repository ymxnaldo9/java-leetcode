package tree._1676;

import java.util.HashSet;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node:nodes)
            values.add(node.val);
        return find(root, values);
    }
    public TreeNode find(TreeNode root, HashSet<Integer> values){
        if (root == null)
            return null;
        if (values.contains(root.val))
            return root;
        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);
        if (left != null && right != null)
            return root;
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
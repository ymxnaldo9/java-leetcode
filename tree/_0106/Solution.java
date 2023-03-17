package tree._0106;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> valtoindex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            valtoindex.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend){
        if (instart > inend)
            return null;
        if (instart == inend)
            return new TreeNode(inorder[instart]);
        int rootval = postorder[postend];
        int index = valtoindex.get(rootval);
        int leftlen = index - instart;
        TreeNode root = new TreeNode(rootval);
        root.left = build(inorder, postorder, instart, index - 1, poststart, poststart + leftlen - 1);
        root.right = build(inorder, postorder, index + 1, inend, poststart + leftlen, postend - 1);
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
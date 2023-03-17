package tree._0105;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    Map<Integer, Integer> valtoindex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valtoindex.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
    public TreeNode build(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){
        if (prestart > preend)
            return null;
        int rootval = preorder[prestart];
        int index = valtoindex.get(rootval);
        int len = index - instart;
        TreeNode root = new TreeNode(rootval);
        root.left = build(preorder, inorder, prestart + 1, prestart + len, instart, index - 1);
        root.right = build(preorder, inorder, prestart + len + 1, preend, index + 1, inend);
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
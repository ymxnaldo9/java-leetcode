package tree._0889;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    Map<Integer, Integer> valtoindex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++)
            valtoindex.put(postorder[i], i);
        return build(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode build (int[] preorder, int[] postorder, int prestart, int preend, int poststart, int postend){
        if (prestart > preend)
            return null;
        if (prestart == preend)
            return new TreeNode(preorder[prestart]);
        int rootval = preorder[prestart];
        int leftrootval = preorder[prestart + 1];
        int index = valtoindex.get(leftrootval);
        int leftlen = index - poststart + 1;
        TreeNode root = new TreeNode(rootval);
        root.left = build(preorder, postorder, prestart + 1, prestart + leftlen, poststart, index);
        root.right = build(preorder, postorder, prestart + leftlen + 1, preend, index + 1, preend - 1);
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
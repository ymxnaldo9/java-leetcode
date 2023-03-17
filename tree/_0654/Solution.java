package tree._0654;

import java.util.Arrays;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int maxvalue = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > maxvalue){
                maxvalue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxvalue);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
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
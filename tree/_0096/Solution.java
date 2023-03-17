package tree._0096;

public class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }
    public int count(int l, int r){
        if (l > r)
            return 1;
        if (memo[l][r] != 0)
            return memo[l][r];
        int res = 0;
        for (int i = l; i <= r; i++){
            int left = count(l, i - 1);
            int right = count(i + 1, r);
            res += left * right;
        }
        memo[l][r] = res;
        return res;
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

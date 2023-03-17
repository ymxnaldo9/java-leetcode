package array._0528;

import java.util.Random;

public class Solution {
    private int[] presum;
    private Random rand = new Random();
    public Solution(int[] w) {
        presum = new int[w.length + 1];
        presum[0] = 0;
        for (int i = 1; i <= w.length; i++)
            presum[i] = presum[i - 1] + w[i - 1];
    }
    public int pickIndex() {
        int n = presum.length;
        int target = rand.nextInt(presum[n - 1]) + 1;
        return leftbound(presum, target) - 1;
    }
    private int leftbound(int[] nums, int target){
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return left;
    }
}

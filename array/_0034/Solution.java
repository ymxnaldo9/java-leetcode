package array._0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftbound(nums, target), rightbound(nums, target)};
    }
    public int leftbound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] == target)
                right = mid - 1;
        }
        if (left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }
    public int rightbound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] == target)
                left = mid + 1;
        }
        if (left - 1 < 0)
            return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}

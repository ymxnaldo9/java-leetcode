package array._0327;

public class Solution {
    private int lower;
    private int upper;
    private long[] temp;
    private int count = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] presum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            presum[i + 1] = (long)nums[i] + presum[i];
        sort(presum);
        return count;
    }
    public void sort(long[] nums){
        temp = new long[nums.length];
        mergesort(nums, 0, nums.length - 1);
    }
    private void mergesort(long[] nums, int left, int right){
        if (left == right)
            return;
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(long[] nums, int left, int mid, int right){
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];
        int start = mid + 1;
        int end = mid + 1;
        for (int i = left; i <= mid; i++){
            while (start <= right && nums[start] - nums[i] < lower)
                start++;
            while (end <= right && nums[end] - nums[i] <= upper)
                end++;
            count += end - start;
        }
        int i = left;
        int j = mid + 1;
        for (int p = left; p <= right; p++){
            if (i == mid + 1)
                nums[p] = temp[j++];
            else if (j == right + 1)
                nums[p] = temp[i++];
            else if (temp[i] > temp[j])
                nums[p] = temp[j++];
            else
                nums[p] = temp[i++];
        }
    }
}

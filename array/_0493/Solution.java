package array._0493;

public class Solution {
    private int[] temp;
    private int count;
    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }
    public void sort(int[] nums){
        temp = new int[nums.length];
        mergesort(nums, 0, nums.length - 1);
    }
    public void mergesort(int[] nums, int left, int right){
        if (left == right)
            return;
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];
        int end = mid + 1;
        for (int i = left; i <= mid; i++){
            while (end <= right && (long)nums[i] > (long)nums[end] * 2)
                end++;
            count += end - (mid + 1);
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

package array._0410;

public class Solution {
    public static void main(String... args){
        Solution s = new Solution();
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(s.splitArray(nums, 2));
    }
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num:nums)
            right += num;
        while (right - left > 1){
            int mid = left + (right - left) / 2;
            if (iscalk(nums, mid, k))
                right = mid;
            else
                left = mid;
        }
        return right;
    }
    public boolean iscalk(int[] nums, int t, int k){
        int count = 1;
        int cur = t;
        for (int num:nums){
            if (num > t)
                return false;
            if (cur >= num)
                cur -= num;
            else{
                count++;
                cur = t - num;
            }
        }
        if (count > k)
            return false;
        else
            return true;
    }
}

package array._0875;

public class Solution {
    public static void main(String... args){
        Solution s = new Solution();
        int[] nums = new int[]{30, 11, 23, 4, 20};
        System.out.println(s.minEatingSpeed(nums, 5));
    }
    public int minEatingSpeed(int[] piles, int h) {
        long left = 0;
        long right = 0;
        for (int pile:piles)
            right += pile;
        while (right - left > 1){
            System.out.println(left);
            System.out.println(right);
            long mid = left + (right - left) / 2;
            int hour = eatinghours(piles, mid);
            System.out.println(hour);
            if (hour > h)
                left = mid;
            else if (hour <= h)
                right = mid;
        }
        return (int)right;
    }
    public int eatinghours(int[] piles, long speed){
        int res = 0;
        for (int pile:piles)
            res += ((pile - 1) / speed) + 1;
        return res;
    }
}

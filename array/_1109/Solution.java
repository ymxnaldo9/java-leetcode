package array._1109;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        difference df = new difference(nums);
        for (int[] booking: bookings)
            df.add(booking[0] - 1, booking[1] - 1, booking[2]);
        return df.result();
    }
}
class difference{
    private int[] diff;
    public difference(int[] nums){
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            diff[i] = nums[i] - nums[i - 1];
    }
    public void add(int i, int j, int val){
        diff[i] += val;
        if (j + 1 < diff.length)
            diff[j + 1] -= val;
    }
    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++)
            res[i] = res[i - 1] + diff[i];
        return res;
    }
}

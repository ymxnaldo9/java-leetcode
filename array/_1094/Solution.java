package array._1094;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        difference df = new difference(nums);
        for (int[] trip: trips)
            df.add(trip[1], trip[2] - 1, trip[0]);
        int[] res = df.result();
        for (int i = 0; i < res.length; i++)
            if (res[i] > capacity)
                return false;
        return true;
    }
}
class difference{
    private int[] diff;
    public difference(int[] nums) {
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
package array._1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight:weights)
            right += weight;
        while (right - left > 1){
            int mid = left + (right - left) / 2;
            if (withindays(weights, days, mid) == false)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
    public boolean withindays(int[] weights, int days, int ship){
        int d = days;
        int cur = ship;
        for (int weight:weights){
            if (weight > ship)
                return false;
            if (cur >= weight)
                cur -= weight;
            else{
                if (--d == 0)
                    return false;
                cur = ship - weight;
            }
        }
        return true;
    }
}

package array._0059;

public class Solution {
    public int[][] generateMatrix(int n) {
        int upper = 0;
        int lower = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        int[][] res = new int[n][n];
        while (num <= n * n){
            if (upper <= lower){
                for (int i = left; i <= right; i++)
                    res[upper][i] = num++;
                upper++;
            }
            if (left <= right){
                for (int j = upper; j <= lower; j++)
                    res[j][right] = num++;
                right--;
            }
            if (upper <= lower){
                for (int i = right; i >= left; i--)
                    res[lower][i] = num++;
                lower--;
            }
            if (left <= right){
                for (int j = lower; j >= upper; j--)
                    res[j][left] = num++;
                left++;
            }
        }
        return res;
    }
}

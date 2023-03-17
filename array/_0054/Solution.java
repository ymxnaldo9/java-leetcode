package array._0054;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper = 0;
        int lower = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n){
            if (upper <= lower){
                for (int i = left; i <= right; i++)
                    res.add(matrix[upper][i]);
                upper++;
            }
            if (left <= right){
                for (int j = upper; j <= lower; j++)
                    res.add(matrix[j][right]);
                right--;
            }
            if (upper <= lower){
                for (int i = right; i >= left; i--)
                    res.add(matrix[lower][i]);
                lower--;
            }
            if (left <= right){
                for (int j = lower; j >= upper; j--)
                    res.add(matrix[j][left]);
                left++;
            }
        }
        return res;
    }
}

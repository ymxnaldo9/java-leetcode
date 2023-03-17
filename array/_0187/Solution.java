package array._0187;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++){
            switch (s.charAt(i)){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        int rl = (int) Math.pow(4, 9);
        int windowhash = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length){
            windowhash = 4 * windowhash + nums[right];
            right++;
            if (right - left == 10){
                if (seen.contains(windowhash))
                    res.add(s.substring(left, right));
                else
                    seen.add(windowhash);
                windowhash = windowhash - nums[left] * rl;
                left++;
            }
        }
        return new LinkedList<>(res);
    }
}

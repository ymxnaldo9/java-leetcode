package array._0003;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()){
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.get(s.charAt(right)) > 1){
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            if (right - left + 1 > res)
                res = right - left + 1;
            right++;
        }
        return res;
    }
}

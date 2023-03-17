package array._0567;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("ab", "eidboaoo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            window.put(s1.charAt(i), window.getOrDefault(s1.charAt(i), 0) + 1);
        int left = 0;
        int right = 0;
        while (right < s2.length()){
            need.put(s2.charAt(right), need.getOrDefault(s2.charAt(right), 0) + 1);
            while (ispermap(window, need)){
                if (right - left == s1.length() - 1){
                    if (window.equals(need)){
                        return true;
                    }
                }
                else{
                    need.put(s2.charAt(left), need.get(s2.charAt(left)) - 1);
                    if (need.get(s2.charAt(left)) == 0)
                        need.remove(s2.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return false;
    }
    private boolean ispermap(Map<Character, Integer> window, Map<Character, Integer> need){
        for (Character key: window.keySet())
            if (!need.containsKey(key) || need.get(key) < window.get(key))
                return false;
        return true;
    }
}

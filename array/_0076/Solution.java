package array._0076;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < t.length(); i++)
            window.put(t.charAt(i), window.getOrDefault(t.charAt(i), 0) + 1);
        int start = 0;
        int end = s.length();
        while (right < s.length()){
            need.put(s.charAt(right), need.getOrDefault(s.charAt(right), 0) + 1);
            while (issamemap(window, need)){
                if (right - left < end - start){
                    start = left;
                    end = right;
                }
                need.put(s.charAt(left), need.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        if (end == s.length())
            return "";
        return s.substring(start, end + 1);
    }
    private boolean issamemap(Map<Character, Integer> window, Map<Character, Integer> need){
        for (Character key: window.keySet())
            if (!need.containsKey(key) || need.get(key) < window.get(key))
                return false;
        return true;
    }
}

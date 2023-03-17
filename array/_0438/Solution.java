package array._0438;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char ch: p.toCharArray())
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        List<Integer> res = new ArrayList<>();
        while (right < s.length()){
            need.put(s.charAt(right), need.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 == p.length()){
                if (window.equals(need))
                    res.add(left);
                need.put(s.charAt(left), need.get(s.charAt(left)) - 1);
                if (need.get(s.charAt(left)) == 0)
                    need.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return res;
    }
    private boolean ispermap(Map<Character, Integer> window, Map<Character, Integer> need){
        for (Character key: window.keySet())
            if (!need.containsKey(key) || need.get(key) < window.get(key))
                return false;
        return true;
    }
}

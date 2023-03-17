package array._1081;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public String smallestSubsequence(String s) {
        char[] chars = s.toCharArray();
        int[] lastindex = new int[26];
        for (int i = 0; i < chars.length; i++){
            lastindex[chars[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] instack = new boolean[26];
        for (int i = 0; i < chars.length; i++){
            if (instack[chars[i] - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peekLast() >= chars[i] && i < lastindex[stack.peekLast() - 'a']){
                char c = stack.pollLast();
                instack[c - 'a'] = false;
            }
            stack.offerLast(chars[i]);
            instack[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character item:stack){
            sb.append(item);
        }
        return sb.toString();
    }
}

package array._0028;

public class Solution {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        int r = 256;
        long q = 1658598167;
        long rl = 1;
        for (int i = 1; i < l; i++)
            rl = (rl * r) % q;
        long needlehash = 0;
        for (int i = 0; i < l; i++)
            needlehash = (r * needlehash + needle.charAt(i)) % q;
        long windowhash = 0;
        int left = 0;
        int right = 0;
        while (right < haystack.length()){
            windowhash = ((r * windowhash) % q + haystack.charAt(right)) % q;
            right++;
            if (right - left == l){
                if (windowhash == needlehash)
                    if (needle.equals(haystack.substring(left, right)))
                        return left;
                windowhash = (windowhash - (haystack.charAt(left) * rl) % q + q) % q;
                left++;
            }
        }
        return -1;
    }
}

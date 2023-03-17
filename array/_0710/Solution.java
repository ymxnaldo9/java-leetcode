package array._0710;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Solution {
    int sz;
    Map<Integer, Integer> mapping;
    public Solution(int n, int[] blacklist) {
        sz = n - blacklist.length;
        mapping = new HashMap<Integer, Integer>();
        for (int black:blacklist)
            mapping.put(black, 666);
        int last = n - 1;
        for (int black:blacklist){
            if (black >= sz)
                continue;
            while (mapping.containsKey(last))
                last--;
            mapping.put(black, last);
            last--;
        }
    }
    public int pick() {
        Random rand = new Random();
        int index = rand.nextInt(sz) % sz;
        if (mapping.containsKey(index))
            return mapping.get(index);
        return index;
    }
}

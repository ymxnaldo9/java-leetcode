package array._0380;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> valtoindex;
    public RandomizedSet() {
        nums = new ArrayList<>();
        valtoindex = new HashMap<>();
    }
    public boolean insert(int val) {
        if (valtoindex.containsKey(val))
            return false;
        valtoindex.put(val, nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val) {
        if (!valtoindex.containsKey(val))
            return false;
        int index = valtoindex.get(val);
        valtoindex.put(nums.get(nums.size() - 1), index);
        Collections.swap(nums, index, nums.size() - 1);
        nums.remove(nums.size() - 1);
        valtoindex.remove(val);
        return true;
    }
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}

package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (intMap.containsKey(target - nums[i])) {
                result = new int[]{intMap.get(target - nums[i]), i};
            }
            intMap.put(nums[i], i);
        }
        return result;
    }
}

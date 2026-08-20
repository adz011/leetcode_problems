package solutions;

import java.util.HashMap;
import java.util.Map;

public class _0001TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            } else {
                numsMap.putIfAbsent(nums[i], i);
            }
        } return new int[]{};
    }
}

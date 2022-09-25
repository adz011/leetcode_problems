import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,25};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}
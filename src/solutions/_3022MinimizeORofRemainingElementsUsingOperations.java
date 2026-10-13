package solutions;

import java.util.Arrays;

public class _3022MinimizeORofRemainingElementsUsingOperations {
    public int minOrAfterOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0;
        int c = k;
        while (c > 0) {
            max = Math.max(max, (k & nums[n - 1 + k - c]));
            c--;
        }
        max = Math.max(max, nums[n - k]);

        return max;

    }

}

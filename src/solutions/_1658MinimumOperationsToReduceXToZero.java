package solutions;

import java.util.Arrays;

public class _1658MinimumOperationsToReduceXToZero {

    static public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;
        for (int w : nums) total += w;
        int right = 0, left = 0, target = 0, maxTargetLength = 0;

        if (total == x) return n;
        
        for (; right < n; right++) {
            target += nums[right];
            while (total - target < x && left < right) {
                target -= nums[left];
                left++;
            }
            if (total - target == x) maxTargetLength = Math.max(maxTargetLength, right - left + 1);
        }
        return maxTargetLength == 0 ? -1 : n - maxTargetLength;
    }

    static public int minOperationsRecursionAndMemo(int[] nums, int x) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int ans = recur(nums, x, 0, n - 1, n, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static public int recur(int[] nums, int x, int left, int right, int n, int[][] memo) {
        if (x == 0) return left + n - right - 1;
        if (x < 0 || right < left) return Integer.MAX_VALUE;
        if (memo[left][right] != -1) return memo[left][right];
        int ans = Math.min(recur(nums, x - nums[left], left + 1, right, n, memo), recur(nums, x - nums[right], left, right - 1, n, memo));
        return memo[left][right] = ans;
    }
}

package solutions;

import java.util.Arrays;

public class _3041MaximizeConsecutiveElementsInAnArrayAfterModification {
    static public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        int max = 1;
        Arrays.sort(nums);
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            dp[i][0] = Math.max(curr - 1 == prev ? dp[i-1][0] + 1 : 1, curr - 1 == prev + 1 ? dp[i-1][1] + 1 : 1 );
            dp[i][1] = Math.max(curr == prev ? dp[i-1][0] + 1 : 1, curr == prev + 1 ? dp[i-1][1] + 1 : curr == prev ? dp[i-1][1] :1 );
            max = Math.max(max, Math.max(dp[i][1], dp[i][0]));
        }
        return max;
    }

}

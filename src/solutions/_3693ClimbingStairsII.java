package solutions;

public class _3693ClimbingStairsII {
    static public int climbStairs(int n, int[] costs) {
        if (n == 1) return costs[0] + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = costs[0] + 1;
        for (int i = 2; i <= n; i++) {
            int j = i - 2;
            dp[i] = dp[i - 1] + costs[i - 1] + 1;
            while (j > -1 && j >= i - 3) {
                dp[i] = Math.min(dp[i], dp[j] + costs[i - 1] + (int) Math.pow(i - j, 2));
                j--;
            }
        }
        return dp[n];
    }

    static public int fasterNonElegantVersion(int n, int[] costs) {
        if (n == 1) return costs[0] + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = costs[0] + 1;
        dp[2] = Math.min(dp[1] + costs[1] + 1, dp[0] + costs[1] + 4);

        if (n == 2) return dp[2];

        for (int i = 2; i < n; i++) {
            dp[i + 1] = Math.min(dp[i] + 1, Math.min(dp[i - 1] + 4, dp[i - 2] + 9))
                    + costs[i];
        }

        return dp[n];
    }

}

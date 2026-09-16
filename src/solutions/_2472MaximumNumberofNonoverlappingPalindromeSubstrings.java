package solutions;

public class _2472MaximumNumberofNonoverlappingPalindromeSubstrings {
    static public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i - k >= 0 && isPalindrome(s, i - k, i - 1))
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            if (i - k - 1 >= 0 && isPalindrome(s, i - k - 1, i - 1))
                dp[i] = Math.max(dp[i], dp[i - k - 1] + 1);
        }

        return dp[n];
    }
    static private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

package solutions;

import java.util.ArrayList;
import java.util.List;

public class _1177CanMakePalindromeFromSubstring {
    static public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] dp = new int[n];
        List<Boolean> ans = new ArrayList<>();
        dp[0] = 1 << s.charAt(0) - 'a';
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] ^ (1 << (s.charAt(i) - 'a'));
        }

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];

            int c = left > 0 ? dp[right] ^ dp[left - 1] : dp[right];
            ans.add(Integer.bitCount(c) <= (k * 2) + 1);
        }
        return ans;
    }
}

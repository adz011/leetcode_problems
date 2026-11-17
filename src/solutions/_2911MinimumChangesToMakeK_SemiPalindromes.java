package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2911MinimumChangesToMakeK_SemiPalindromes {
    final int MAX = 100_000;

    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (j == i) cost[i][j] = MAX;
                else cost[i][j] = minChangesToIteration(s.substring(i, j + 1));
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, MAX);
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j][i - 1]);
                }
            }
        }
        return dp[n][k];

    }

    private int minChangesToPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        int diff = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                diff++;
            }
            l++;
            r--;
        }
        return diff;
    }

    private int minChangesToPalindromeList(List<String> palindromes) {
        return palindromes.stream().mapToInt(this::minChangesToPalindrome).sum();
    }

    private int minChangesToIteration(String s) {
        int n = s.length();
        int min = MAX;
        List<String> list;
        StringBuilder sb;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) continue;
            list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                sb = new StringBuilder();
                int multiplier = 0;
                while (i * multiplier + j < s.length()) {
                    sb.append(s.charAt(i * multiplier + j));
                    multiplier++;
                }
                list.add(sb.toString());
            }
            min = Math.min(min, minChangesToPalindromeList(list));
        }
        return min;
    }


}

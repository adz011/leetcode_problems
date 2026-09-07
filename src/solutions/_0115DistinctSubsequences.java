package solutions;

public class _0115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return 0;
        long[] ways = new long[m + 1];
        ways[0] = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = Math.min(i, m - 1); j > -1; j--) {
                if (t.charAt(j) == c) ways[j + 1] += ways[j];
            }
        }

        return (int) ways[m];
    }
}

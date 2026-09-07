package solutions;
public class _0940DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] ends = new long[27];

        for (char ch : s.toCharArray()) {
            long total = 0;
            for (long e : ends) total = (total + e) % MOD;
            ends[ch & 31] = (total + 1) % MOD;
        }

        long answer = 0;
        for (long e : ends) answer = (answer + e) % MOD;
        return (int) answer;
    }
}

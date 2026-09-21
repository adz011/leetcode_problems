package solutions;

public class _3524FindXValueofArrayI {
    static public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] counts = new long[k];
        long[] next = new long[k];

        for (int num : nums) {
            int v = num % k;

            java.util.Arrays.fill(next, 0L);
            next[v]++;
            for (int r = 0; r < k; r++) {
                if (counts[r] != 0) next[r * v % k] += counts[r];
            }

            long[] swap = counts;
            counts = next;
            next = swap;

            for (int r = 0; r < k; r++) result[r] += counts[r];
        }

        return result;
    }
}

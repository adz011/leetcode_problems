package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2333MinimumSumofSquaredDifference {
    static public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long total = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max, diff[i]);
        }
        long k = k1 + k2;
        if (total <= k) return 0;

        int lo = 0, hi = max;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (cost(diff, mid) <= k) hi = mid;
            else lo = mid + 1;
        }
        int T = lo;
        long r = k - cost(diff, T);

        long sum = 0;
        for (int d : diff) {
            long v = Math.min(d, T);
            if (d >= T && r > 0) {
                v--;
                r--;
            }
            sum += v * v;
        }
        return sum;
    }

    static long cost(int[] diff, int x) {
        long c = 0;
        for (int d : diff) c += Math.max(0, d - x);
        return c;
    }
}

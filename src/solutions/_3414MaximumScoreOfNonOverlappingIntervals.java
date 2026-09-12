package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _3414MaximumScoreOfNonOverlappingIntervals {

    private static final int[] EMPTY = new int[0];

    public static int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> it = intervals.get(i);
            arr[i] = new int[]{it.get(0), it.get(1), it.get(2), i};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = arr[i][0];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) next[i] = upperBound(starts, arr[i][1]);

        long[][] best = new long[n + 1][5];
        int[][][] pick = new int[n + 1][5][];
        Arrays.fill(pick[n], EMPTY);

        for (int i = n - 1; i >= 0; i--) {
            pick[i][0] = EMPTY;
            for (int k = 1; k <= 4; k++) {
                long skipScore = best[i + 1][k];
                int[] skipIdx = pick[i + 1][k];

                int j = next[i];
                long takeScore = arr[i][2] + best[j][k - 1];
                int[] takeIdx = insert(pick[j][k - 1], arr[i][3]);

                if (takeScore > skipScore || (takeScore == skipScore && less(takeIdx, skipIdx))) {
                    best[i][k] = takeScore;
                    pick[i][k] = takeIdx;
                } else {
                    best[i][k] = skipScore;
                    pick[i][k] = skipIdx;
                }
            }
        }
        return pick[0][4];
    }

    private static int upperBound(int[] starts, int value) {
        int lo = 0, hi = starts.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (starts[mid] > value) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int[] insert(int[] sorted, int value) {
        int[] res = new int[sorted.length + 1];
        int p = 0;
        while (p < sorted.length && sorted[p] < value) {
            res[p] = sorted[p];
            p++;
        }
        res[p] = value;
        System.arraycopy(sorted, p, res, p + 1, sorted.length - p);
        return res;
    }

    private static boolean less(int[] a, int[] b) {
        int m = Math.min(a.length, b.length);
        for (int i = 0; i < m; i++) {
            if (a[i] != b[i]) return a[i] < b[i];
        }
        return a.length < b.length;
    }
}

package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class _3505MinimumOperationsToMakeElementsWithinKSubarraysEqual {
    private int[] nums;
    private TreeSet<Integer> low, high;
    private long sumLow, sumHigh;

    public long minOperations(int[] nums, int x, int k) {
        this.nums = nums;
        int n = nums.length;
        Comparator<Integer> cmp = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
        low = new TreeSet<>(cmp);
        high = new TreeSet<>(cmp);
        sumLow = 0;
        sumHigh = 0;

        long[] cost = new long[n - x + 1];
        for (int i = 0; i < x; i++) add(i);
        cost[0] = windowCost();
        for (int i = x; i < n; i++) {
            remove(i - x);
            add(i);
            cost[i - x + 1] = windowCost();
        }

        final long INF = Long.MAX_VALUE / 2;
        long[] prev = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = j * x; i <= n; i++) {
                cur[i] = Math.min(cur[i - 1], prev[i - x] + cost[i - x]);
            }
            prev = cur;
        }
        return prev[n];
    }

    private long windowCost() {
        long med = nums[low.last()];
        return med * low.size() - sumLow + sumHigh - med * high.size();
    }

    private void add(int i) {
        if (low.isEmpty() || nums[i] <= nums[low.last()]) {
            low.add(i);
            sumLow += nums[i];
        } else {
            high.add(i);
            sumHigh += nums[i];
        }
        rebalance();
    }

    private void remove(int i) {
        if (low.remove(i)) sumLow -= nums[i];
        else {
            high.remove(i);
            sumHigh -= nums[i];
        }
        rebalance();
    }

    private void rebalance() {
        if (low.size() > high.size() + 1) {
            int m = low.pollLast();
            sumLow -= nums[m];
            high.add(m);
            sumHigh += nums[m];
        } else if (high.size() > low.size()) {
            int m = high.pollFirst();
            sumHigh -= nums[m];
            low.add(m);
            sumLow += nums[m];
        }
    }
}

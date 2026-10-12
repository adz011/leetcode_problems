package solutions;

import java.util.List;

public class _2897ApplyOperationsonArraytoMaximizeSumofSquares {
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[30];
        int MAX = 1000000007;
        int ans = 0;
        for (int x : nums) {
            int v = 1;
            int max = 30;
            while (max > 0) {
                if (v > x) break;
                if ((x & v) > 0) cnt[max]++;
                v = v << 1;
                max--;
            }
        }
        for (int i = 0; i < k; i++) {
            long cur = 0;
            int bit = 1;
            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    cur |= bit;
                }
                bit <<= 1;
            }
            cur = cur * cur % MAX;
            ans = ans + (int) cur % MAX;
            if (ans > MAX) {
                ans %= MAX;
            }
        }
        return ans;
    }
}

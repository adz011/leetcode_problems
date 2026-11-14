package solutions;

import java.util.List;

public class _3364MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        for (int x = l; x <= r; x++) {
            int sum = 0;
            for (int i = 0; i < x; i++) sum += nums.get(i);
            if (sum > 0) ans = Math.min(ans, sum);
            for (int i = x; i < n; i++) {
                sum += nums.get(i) - nums.get(i - x);
                if (sum > 0) ans = Math.min(ans, sum);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

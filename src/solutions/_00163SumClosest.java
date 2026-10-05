package solutions;

import java.util.Arrays;

public class _00163SumClosest {
    static public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, ans = Integer.MAX_VALUE / 2;
        int[] numsCopy = Arrays.copyOf(nums, n);
        Arrays.sort(numsCopy);
        int lo, hi;
        for (int i = 0; i < n - 2; i++) {
            if(i > 0 && numsCopy[i] == numsCopy[i-1]) continue;
            lo = i + 1;
            hi = n - 1;
            int currTarget;
            while (lo < hi) {
                currTarget = numsCopy[i] + numsCopy[lo] + numsCopy[hi];
                ans = Math.abs(currTarget - target) < Math.abs(ans - target) ? currTarget : ans;
                if (currTarget == target) return currTarget;
                if (currTarget < target) lo++;
                if (currTarget > target) hi--;
            }
        }
        return ans;
    }
}
package solutions;

public class _2091RemovingMinimumandMaximumFrom {
    static public int minimumDeletions(int[] nums) {
        int n = nums.length, si = 0, hi = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[si]) si = k;
            if (nums[k] > nums[hi]) hi = k;
        }
        int i = Math.min(si, hi), j = Math.max(si, hi);
        return Math.min(j + 1, Math.min(n - i, i + 1 + n - j));
    }
}

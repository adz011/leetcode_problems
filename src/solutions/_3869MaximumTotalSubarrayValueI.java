package solutions;

public class _3869MaximumTotalSubarrayValueI {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        return (max - min) * k;
    }
}

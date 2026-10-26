package solutions;

public class _0045JumpGameII {
    static public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int left = 1, right = nums[0];
        int jumps = 1;
        while (right < n - 1) {
            jumps++;
            int furthest = 0;
            for (int i = left; i <= right; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            left = right + 1;
            right = furthest;
        }

        return jumps;
    }

}

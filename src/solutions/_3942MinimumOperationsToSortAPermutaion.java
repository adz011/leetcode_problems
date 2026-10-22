package solutions;

public class _3942MinimumOperationsToSortAPermutaion {
    static public int minOperations(int[] nums) {
        int n = nums.length;
        int index0 = n - 1;
        if (n == 2) return nums[0];
        boolean isIncreasing = (nums[0] - nums[1] > 1 || nums[0] - nums[1] == -1);
        boolean wasJump = false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                index0 = i;
            }
            int diff = nums[i + 1] - nums[i];
            if (wasJump && Math.abs(diff) > 1) return -1;
            wasJump = Math.abs(diff) > 1;
            if ((diff == 1 || diff < -1) && !isIncreasing
                    || (diff == -1 || diff > 1) && isIncreasing) return -1;
        }
        return isIncreasing ? Math.min(index0, 2 + n - index0) : Math.min(index0 + 2, 1 + n - index0 - 1);
    }

    static public int minOperationsDirectionCount(int[] nums) {
        int n = nums.length;

        int desc = 1, asc = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == (nums[i - 1] + 1) % n) asc++;
            if (nums[i - 1] == (nums[i] + 1) % n) desc++;
        }

        if (asc == n) return nums[0] == 0 ? 0 : Math.min(n - nums[0], nums[0] + 2);
        if (desc == n) return Math.min(n - nums[0], nums[0] + 2);

        return -1;

    }
}

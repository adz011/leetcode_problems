package solutions;

public class _3886SumOfSortableIntegers {
    static public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        boolean isSorted = checkIfSorted(nums);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (isSorted) sum += i;
                else sum += isSortableWithBlock(i, nums) ? i : 0;
            }
        }
        return sum;
    }

    static private boolean isSortableWithBlock(int x, int[] nums) {
        int n = nums.length;
        int previousMax = 0;
        for (int i = 0; i < n; i += x) {
            int currMin = Integer.MAX_VALUE, currMax = 0;
            boolean dropSeen = false;
            for (int j = i; j < i + x - 1; j++) {
                currMin = Math.min(nums[j], currMin);
                currMax = Math.max(nums[j], currMax);
                if (nums[j] > nums[j + 1]) {
                    if (dropSeen) return false;
                    dropSeen = true;
                }
            }
            currMin = Math.min(nums[i + x - 1], currMin);
            currMax = Math.max(nums[i + x - 1], currMax);
            if ((currMin < previousMax) || (dropSeen && nums[i] < nums[i + x - 1])) return false;
            previousMax = currMax;
        }
        return true;

    }

    static private boolean checkIfSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

}

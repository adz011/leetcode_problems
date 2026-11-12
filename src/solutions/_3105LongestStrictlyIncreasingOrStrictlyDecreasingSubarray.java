package solutions;

public class _3105LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int currSub = 1, maxSub = 1;
        boolean isIncreasing = false;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (isIncreasing) {
                    currSub++;
                } else {
                    currSub = 2;
                    isIncreasing = true;
                }
            } else if (nums[i] < nums[i - 1]) {
                if (!isIncreasing) {
                    currSub++;
                } else {
                    isIncreasing = false;
                    currSub = 2;
                }
            } else {
                currSub = 1;
            }
            maxSub =  Math.max(maxSub, currSub);
        }
        return maxSub;
    }
}

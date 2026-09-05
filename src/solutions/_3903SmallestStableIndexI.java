package solutions;

public class _3903SmallestStableIndexI {
    static public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n], prefixMax = new int[n];

        suffixMin[n - 1] = nums[n - 1];
        prefixMax[0] = nums[0];

        for (int i = n - 2; i > -1; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i+1]);
        }

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
            if(prefixMax[i] - suffixMin[i] <= k)return i;
        }

        return -1;
    }
}

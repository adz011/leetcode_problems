package solutions;

import java.util.Arrays;

public class _3727MaximumAlernatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i =0; i<n;i++){
            int x = nums[i];
            nums[i] = x * x;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int x = nums[i];
            sum -= x;
        }
        for (int i = n / 2; i < n; i++) {
            int x = nums[i];
            sum += x;
        }

        return sum;
    }
}

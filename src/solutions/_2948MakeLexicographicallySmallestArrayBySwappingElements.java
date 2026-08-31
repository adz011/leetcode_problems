package solutions;

import java.util.Arrays;

public class _2948MakeLexicographicallySmallestArrayBySwappingElements {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order);

        int[] result = new int[n];
        int groupStart = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[order[i]] - nums[order[i - 1]] > limit) {
                int[] indices = new int[i - groupStart];
                for (int k = groupStart; k < i; k++) {
                    indices[k - groupStart] = order[k];
                }
                Arrays.sort(indices);
                for (int k = 0; k < indices.length; k++) {
                    result[indices[k]] = nums[order[groupStart + k]];
                }
                groupStart = i;
            }
        }
        return result;
    }
}

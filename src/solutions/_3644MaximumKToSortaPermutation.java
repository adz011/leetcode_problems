package solutions;

public class _3644MaximumKToSortaPermutation {
    public int sortPermutation(int[] nums) {
        int max = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (i != nums[i]) max &= nums[i];
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}

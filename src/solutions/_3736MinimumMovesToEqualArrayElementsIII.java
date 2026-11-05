package solutions;

public class _3736MinimumMovesToEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return max * n - sum;
    }
}

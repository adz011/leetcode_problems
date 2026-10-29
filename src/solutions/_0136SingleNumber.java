package solutions;

public class _0136SingleNumber {
    public int singleNumber(int[] nums) {
        int mask = 0;
        for (int x : nums) {
            mask ^= x;
        }
        return mask;
    }
}

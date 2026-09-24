package solutions;

public class _3550SmallestIndexWithDigitSumEqualtoIndex {
    static public int smallestIndex(int[] nums) {
        int n = nums.length;
        int digitsSum;
        int c;
        for (int i = 0; i < n; i++) {
            digitsSum = 0;
            c = nums[i];
            while (c > 0) {
                digitsSum += c % 10;
                c /= 10;
            }
            if (digitsSum == i) return i;
        }
        return -1;
    }
}

package solutions;

public class _1524NumberOfSubArraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        int even = 1, odd = 0;
        int isOdd = 0;

        for (int x : arr) {
            isOdd ^= (x & 1);
            if (isOdd == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }
        return (int) (ans % MOD);
    }
}

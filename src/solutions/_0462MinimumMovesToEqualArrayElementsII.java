package solutions;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class _0462MinimumMovesToEqualArrayElementsII {
    static public int minMoves2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int middle = quickselect(nums, nums.length / 2);
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - middle);
        }
        return ans;
    }

    static int quickselect(int[] a, int k) {
        Random rnd = ThreadLocalRandom.current();
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int p = a[lo + rnd.nextInt(hi - lo + 1)];
            int lt = lo, i = lo, gt = hi;
            while (i <= gt) {
                if (a[i] < p) swap(a, lt++, i++);
                else if (a[i] > p) swap(a, i, gt--);
                else i++;
            }
            if (k < lt) hi = lt - 1;
            else if (k > gt) lo = gt + 1;
            else return p;
        }
        return a[k];
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

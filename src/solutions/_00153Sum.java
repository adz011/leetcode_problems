package solutions;

import java.util.*;

public class _00153Sum {
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        int[] numsCopy = Arrays.copyOf(nums, n);
        Arrays.sort(numsCopy);
        int lo, hi;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && numsCopy[i] == numsCopy[i - 1]) continue;
            if (numsCopy[i] > 0) break;
            lo = i + 1;
            hi = n - 1;
            int currSum;
            while (lo < hi) {
                currSum = numsCopy[i] + numsCopy[lo] + numsCopy[hi];
                if (currSum == 0) {
                    List<Integer> currList = List.of(numsCopy[i], numsCopy[lo], numsCopy[hi]);
                    triplets.add(currList);
                    while (lo < hi && numsCopy[hi] == numsCopy[hi - 1]) hi--;
                    while (lo < hi && numsCopy[lo] == numsCopy[lo + 1]) lo++;
                    hi--;
                    lo++;
                } else if (currSum > 0) {
                    hi--;
                } else lo++;
            }
        }
        return triplets;
    }
}

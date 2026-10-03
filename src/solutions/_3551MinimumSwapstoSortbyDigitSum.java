package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _3551MinimumSwapstoSortbyDigitSum {
    static public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Pair> digitsSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curr = nums[i], currDigitsSum = 0;
            while (curr > 0) {
                currDigitsSum += curr % 10;
                curr /= 10;
            }
            digitsSum.add(new Pair(i, currDigitsSum));
        }

        digitsSum.sort(Comparator.comparing(Pair::value)
                .thenComparing(p -> nums[p.index()]));
        return swapCount(digitsSum);
    }

    static private int swapCount(List<Pair> list) {
        int n = list.size();
        int swaps = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleCount = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = list.get(j).index();
                    cycleCount++;
                }
                swaps += cycleCount - 1;
            }
        }
        return swaps;
    }

    record Pair(int index, int value) {
    }
}

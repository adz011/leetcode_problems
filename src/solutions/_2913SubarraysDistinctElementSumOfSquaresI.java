package solutions;

import java.util.List;

public class _2913SubarraysDistinctElementSumOfSquaresI {
    static public int sumCounts(List<Integer> nums) {
        boolean[] count;
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            count = new boolean[101];
            int curCount = 0;
            for (int j = i; j < n; j++) {
                int x = nums.get(j);
                if (!count[x]) {
                    curCount++;
                    count[x] = true;
                }
                sum += curCount * curCount;
            }
        }

        return sum;

    }
}

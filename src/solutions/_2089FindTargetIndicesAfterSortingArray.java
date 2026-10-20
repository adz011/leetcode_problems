package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2089FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int smallerThanTarget = 0, targetCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                targetCount++;
            }
            if (nums[i] < target) smallerThanTarget++;
        }
        int i = 0;
        while (i < targetCount) {
            ans.add(smallerThanTarget + i);
            i++;
        }
        return ans;
    }

}

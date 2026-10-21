package solutions;

import java.util.ArrayList;
import java.util.List;

public class _1569NumberOfWaysToReorderArrayToGetSameBST {

    static final int MOD = 1_000_000_007;
    static long[][] newtonTriangleBuild;

    static public int numOfWays(int[] nums) {
        int n = nums.length;
        newtonTriangleBuild = newtonTriangle(n);
        List<Integer> numsCopy = new ArrayList<>();
        for (int x : nums) {
            numsCopy.add(x);
        }
        return (int) ((dfs(numsCopy) - 1 + MOD) % MOD);
    }

    static private long[][] newtonTriangle(int n) {
        long[][] pyramid = new long[n][n];
        pyramid[0][0] = 1;
        for (int i = 1; i < n; i++) {
            pyramid[i][0] = 1;
            pyramid[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pyramid[i][j] = (pyramid[i - 1][j - 1] + pyramid[i - 1][j]) % MOD;
            }
        }
        return pyramid;
    }

    static private long dfs(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 1;
        int root = nums.getFirst();
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                leftNums.add(nums.get(i));
            } else {
                rightNums.add(nums.get(i));
            }
        }
        long ans = newtonTriangleBuild[n - 1][leftNums.size()];
        return ((ans * dfs(leftNums) % MOD) * dfs(rightNums)) % MOD;
    }
}

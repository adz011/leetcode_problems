package solutions;

public class _1477FindTwoNonoverlappingSubarraysEachWithTargetSum {
    static public int minSumOfLengths(int[] arr, int target) {
        int INF = 100_000_007;
        int n = arr.length, r = 0, l = 0, len, ans = INF, sum = 0, cur = INF;
        int[] best = new int[n];
        for (; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                len = r - l + 1;
                // l > 0 works as condition, because all values are > 0, so after first found target, while loop above will increase it by at least one
                if (l > 0 && best[l - 1] != INF) {
                    ans = Math.min(ans, len + best[l - 1]);
                }
                cur = Math.min(cur, len);
            }
            best[r] = cur;
        }

        return ans == INF ? -1 : ans;
    }
}

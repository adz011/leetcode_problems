package solutions;

public class _3525FindXValueofArrayII {

    static public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegTree tree = new SegTree(nums, k);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            tree.set(q[0], q[1]);
            result[i] = tree.countPrefixes(q[2], q[3]);
        }
        return result;
    }
    private static final class SegTree {
        final int k;
        final int kk;
        final int size;
        final int[] prod;
        final int[] cnt;

        SegTree(int[] nums, int k) {
            this.k = k;
            this.kk = k * k;

            int s = 1;
            while (s < nums.length) s <<= 1;
            this.size = s;

            this.prod = new int[2 * s];
            this.cnt = new int[2 * s * kk];

            java.util.Arrays.fill(prod, 1 % k);
            for (int i = 0; i < nums.length; i++) leaf(size + i, nums[i]);
            for (int i = size - 1; i >= 1; i--) pull(i);
        }

        void set(int index, int value) {
            leaf(size + index, value);
            for (int i = (size + index) >> 1; i >= 1; i >>= 1) pull(i);
        }

        int countPrefixes(int start, int x) {
            int[] acc = new int[kk];
            int accProd = 1 % k;

            int l = size + start, r = 2 * size;
            while (l < r) {
                if ((l & 1) != 0) {
                    int base = l * kk;
                    for (int in = 0; in < k; in++) {
                        int entering = in * accProd % k;
                        for (int out = 0; out < k; out++) {
                            acc[in * k + out] += cnt[base + entering * k + out];
                        }
                    }
                    accProd = accProd * prod[l] % k;
                    l++;
                }
                l >>= 1;
                r >>= 1;
            }
            return acc[(1 % k) * k + x];
        }

        private void leaf(int node, int value) {
            int v = value % k;
            int base = node * kk;
            java.util.Arrays.fill(cnt, base, base + kk, 0);
            prod[node] = v;
            for (int in = 0; in < k; in++) cnt[base + in * k + in * v % k] = 1;
        }

        private void pull(int node) {
            int left = node << 1, right = left | 1;
            int leftProd = prod[left];
            prod[node] = leftProd * prod[right] % k;

            int base = node * kk, lb = left * kk, rb = right * kk;
            for (int in = 0; in < k; in++) {
                int entering = in * leftProd % k;
                for (int out = 0; out < k; out++) {
                    cnt[base + in * k + out] = cnt[lb + in * k + out] + cnt[rb + entering * k + out];
                }
            }
        }
    }
}

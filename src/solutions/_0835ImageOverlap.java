package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0835ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> ones1 = ones(img1);
        List<int[]> ones2 = ones(img2);
        Map<Long, Integer> counts = new HashMap<>();
        int best = 0;
        for (int[] a : ones1) {
            for (int[] b : ones2) {
                long key = (long) (a[0] - b[0]) * 128 + (a[1] - b[1]);
                best = Math.max(best, counts.merge(key, 1, Integer::sum));
            }
        }
        return best;
    }

    private static List<int[]> ones(int[][] img) {
        List<int[]> res = new ArrayList<>();
        for (int r = 0; r < img.length; r++) {
            for (int c = 0; c < img[r].length; c++) {
                if (img[r][c] == 1) res.add(new int[]{r, c});
            }
        }
        return res;
    }
}

package solutions;

public class _3484Unique3DigitEvenNumbers {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) cnt[d]++;

        int res = 0;
        for (int h = 1; h <= 9; h++) {
            if (cnt[h] == 0) continue;
            cnt[h]--;
            for (int t = 0; t <= 9; t++) {
                if (cnt[t] == 0) continue;
                cnt[t]--;
                for (int u = 0; u <= 8; u += 2) {
                    if (cnt[u] > 0) res++;
                }
                cnt[t]++;
            }
            cnt[h]++;
        }
        return res;
    }
}

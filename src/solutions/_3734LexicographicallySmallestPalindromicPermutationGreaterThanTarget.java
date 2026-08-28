package solutions;

public class _3734LexicographicallySmallestPalindromicPermutationGreaterThanTarget {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        boolean isOdd = s.length() % 2 == 1;
        int[] sc = new int[27], pali = new int[n];
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) & 31]++;
        }
        int odds = 0, mid = 0;
        for (int i = 0; i < 27; i++) {
            if (sc[i] % 2 == 1) {
                odds++;
                mid = i;
            }
        }
        if (!isOdd && odds > 0 || odds > 1) return "";

        int half = n / 2;

        int i = 0;
        for (; i < half; i++) {
            int curr = target.charAt(i) & 31;
            if (sc[curr] < 2) break;
            pali[i] = curr;
            sc[curr] -= 2;
        }

        if (i == half) {
            if (isOdd) pali[half] = mid;
            mirror(pali, half, n);
            if (greater(pali, target, half, n)) return toStr(pali, n);
            i--;
            if (i < 0) return "";
            sc[target.charAt(i) & 31] += 2;
        }
        for (; i >= 0; i--) {
            int curr = target.charAt(i) & 31;
            int j = curr + 1;
            while (j < 27 && sc[j] < 2) j++;

            if (j < 27) {
                pali[i] = j;
                sc[j] -= 2;
                int k = 0;
                for (int l = i + 1; l < half; l++) {
                    while (sc[k] < 2) k++;
                    pali[l] = k;
                    sc[k] -= 2;
                }
                if (isOdd) pali[half] = mid;
                mirror(pali, half, n);
                return toStr(pali, n);
            }
            if (i > 0) sc[target.charAt(i - 1) & 31] += 2;
        }
        return "";
    }

    private void mirror(int[] pali, int half, int n) {
        for (int i = 0; i < half; i++) {
            pali[n - 1 - i] = pali[i];
        }
    }

    private boolean greater(int[] pali, String target, int from, int n) {
        for (int i = from; i < n; i++) {
            int t = target.charAt(i) & 31;
            if (pali[i] != t) return pali[i] > t;
        }
        return false;
    }

    private String toStr(int[] pali, int n) {
        char[] out = new char[n];
        for (int i = 0; i < n; i++) {
            out[i] = (char) (pali[i] + 96);
        }
        return new String(out);
    }
}

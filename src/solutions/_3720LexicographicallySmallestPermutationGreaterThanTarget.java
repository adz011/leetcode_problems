package solutions;

public class _3720LexicographicallySmallestPermutationGreaterThanTarget {
    public static String lexGreaterPermutation(String s, String target) {
        int[] sA = new int[27];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            sA[s.charAt(i) & 31]++;
        }

        int[] matched = new int[n];
        int k = 0;
        while (k < n) {
            int cc = target.charAt(k) & 31;
            if (sA[cc] == 0) {
                break;
            }
            sA[cc]--;
            matched[k] = cc;
            k++;
        }

        for (int i = Math.min(k, n - 1); i >= 0; i--) {
            if (i < k) {
                sA[matched[i]]++;
            }
            int cc = target.charAt(i) & 31;
            for (int j = cc + 1; j < 27; j++) {
                if (sA[j] > 0) {
                    sA[j]--;
                    StringBuilder sb = new StringBuilder();
                    sb.append(target, 0, i);
                    sb.append((char) (j + 96));
                    for (int c = 1; c < 27; c++) {
                        while (sA[c]-- > 0) {
                            sb.append((char) (c + 96));
                        }
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }
}
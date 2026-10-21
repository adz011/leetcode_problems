package solutions;

public class _3863MinimumOperationsToSortAString {
    static public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char min = s.charAt(0), max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c < min) min = c;
            if (c > max) max = c;
            if (c > s.charAt(i - 1)) isSorted = false;
        }

        if (isSorted) return 0;
        if (n == 2) return -1;
        if (s.charAt(0) == min || s.charAt(n - 1) == max) return 1;

        for (int i = 1; i < n - 1; i++) {
            int c = s.charAt(i);
            if (c == min || c == max) return 2;
        }
        return 3;
    }
}

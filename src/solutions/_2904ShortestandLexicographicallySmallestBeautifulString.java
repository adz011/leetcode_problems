package solutions;

public class _2904ShortestandLexicographicallySmallestBeautifulString {

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = -1;
        int right = -1;
        int ones = 0;

        for (int i = 0; i < n && ones < k; i++) {
            if (s.charAt(i) == '1') {
                ones++;
                if (ones == 1) {
                    left = i;
                }
                right = i + 1;
            }
        }
        if (ones < k) {
            return "";
        }

        String best = s.substring(left, right);

        for (int i = right; i < n; i++) {
            if (s.charAt(i) != '1') {
                continue;
            }
            do {
                left++;
            } while (s.charAt(left) != '1');
            right = i + 1;

            String candidate = s.substring(left, right);
            if (candidate.length() < best.length()
                    || (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                best = candidate;
            }
        }

        return best;
    }
}

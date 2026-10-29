package solutions;

public class _1400ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        boolean[] isOdd = new boolean[26];
        int oddCount = 0;

        if(k > n) return false;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            isOdd[c] = !isOdd[c];
        }

        for (int i = 0; i < 26; i++) {
            if (isOdd[i]) oddCount++;
        }

        return oddCount < k;
    }
}

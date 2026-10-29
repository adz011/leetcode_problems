package solutions;

public class _1400ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(k > n) return false;

        boolean[] isOdd = new boolean[26];
        int oddCount = 0;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            isOdd[c] = !isOdd[c];
        }

        for (int i = 0; i < 26; i++) {
            if (isOdd[i]) oddCount++;
        }

        return oddCount <= k;
    }
}

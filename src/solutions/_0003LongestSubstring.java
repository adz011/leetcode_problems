package solutions;

public class _0003LongestSubstring {
    public int solution(String s) {
        int[] symbolsIndices = new int[256];
        int max = 0;
        for(int i = 0, j = 0; i< s.length(); i++){
            int c = s.charAt(i);
            j = Math.max (j, symbolsIndices[c]);
            symbolsIndices[c] = i+1;
            max = Math.max(max, i - j + 1);
        } return max;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] symbolsIndices = new int[256];
        int sum = 0;
        for(int i = 0, j = 0; i< s.length(); i++){
            if(symbolsIndices[s.charAt(i)] > 0){
                j = Math.max (j , symbolsIndices[s.charAt(i)]);

            }
            symbolsIndices[s.charAt(i)] = i+1;
            sum = Math.max(sum, i - j + 1);
        } return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcbbabcd"));
    }
}
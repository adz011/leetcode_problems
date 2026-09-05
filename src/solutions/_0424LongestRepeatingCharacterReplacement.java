package solutions;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Constraints:
 * <p>
 * -- 1 <= s.length <= 105
 * -- s consists of only uppercase English letters.
 * -- 0 <= k <= s.length
 */
public class _0424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] occ = new int[27];
        int maxLetterCount = 0, currentMaxLetter = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            int currChar = s.charAt(i) & 31;
            if (occ[currentMaxLetter] < ++occ[currChar]) {
                currentMaxLetter = occ[currentMaxLetter] < occ[currChar] ? occ[currChar] : currentMaxLetter;
            }
            if(i - j + 1 - currentMaxLetter > k){
                occ[s.charAt(j) & 31]--;
                j++;
            }

            maxLetterCount = Math.max(maxLetterCount, i - j + 1);
        }
        return maxLetterCount;
    }

    /**
     * ABABA
     */
}

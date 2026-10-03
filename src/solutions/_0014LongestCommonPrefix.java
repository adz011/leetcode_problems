package solutions;

public class _0014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int maxLen = 200;
        for(String s : strs){
            maxLen = Math.min(s.length(), maxLen);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if(c != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

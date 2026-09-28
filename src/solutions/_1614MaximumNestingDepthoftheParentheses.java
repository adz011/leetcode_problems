package solutions;

public class _1614MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int n = s.length();
        int nestingDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                currentDepth++;
                nestingDepth = Math.max(currentDepth, nestingDepth);
            }else if(s.charAt(i) ==')'){
                currentDepth--;
            }
        }
        return nestingDepth;
    }
}

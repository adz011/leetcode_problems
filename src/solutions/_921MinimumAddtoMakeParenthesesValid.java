package solutions;

public class _921MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int opens = 0;
        int closed = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                opens++;
            } else if (opens == 0) {
                closed++;

            } else opens--;
        }
        return opens + closed;
    }
}

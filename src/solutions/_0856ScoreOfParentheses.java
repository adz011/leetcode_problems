package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0856ScoreOfParentheses {
    static public int scoreOfParentheses(String s) {
        int n = s.length();
        int score = 0, depth =0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // since it is VPS, we won't reach array out of bounds exception
                if (s.charAt(i-1) == '(') score += 1 << depth ;
            }
        }
        return score;
    }

}

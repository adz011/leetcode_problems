package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0032LongestValidParantheses {
    static public int longestValidParenthesesTwoPass(String s) {
        int n = s.length();
        int ans = 0;

        int open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++; else close++;
            if (open == close) {
                ans = Math.max(ans, 2 * close);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for (int i = n - 1; i>=0; i--) {
            if (s.charAt(i) == '(') open++; else close++;
            if (open == close) {
                ans = Math.max(ans, open + close);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return ans;
    }

    static public int longestValidParenthesesStack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}

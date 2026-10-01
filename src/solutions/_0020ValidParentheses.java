package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0020ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.removeFirst() != '(') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.removeFirst() != '{') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.removeFirst() != '[') return false;
            } else stack.addFirst(c);
        }
        return stack.isEmpty();
    }
}

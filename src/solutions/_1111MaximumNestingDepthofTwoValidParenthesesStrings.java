package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1111MaximumNestingDepthofTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == ')') {
                if (depth % 2 == 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = 1;
                }
                depth--;
            } else {
                if (depth % 2 == 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = 1;
                }
                depth++;
            }
        }
        return ans;
    }

    public int[] maxDepthAfterSplitUsingStack(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        Deque<Character> stack = new ArrayDeque<>();
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == ')') {
                if (stack.removeFirst() == 'a') {
                    ans[i] = 0;
                } else {
                    ans[i] = 1;
                }
                depth--;
            } else {
                if (depth % 2 == 0) {
                    stack.add('a');
                    ans[i] = 0;
                } else {
                    stack.add('b');
                    ans[i] = 1;
                }
                depth++;
            }
        }
        return ans;
    }
}

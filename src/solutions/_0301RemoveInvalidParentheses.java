package solutions;

import java.util.*;

public class _0301RemoveInvalidParentheses {

    static public List<String> removeInvalidParentheses(String s) {
        Set<String> afterClosed = iteration(s);

        Set<String> afterOpened = new HashSet<>();
        Set<String> reversed = reverseSet(afterClosed);
        for (String r: reversed) {
            afterOpened.addAll(iteration(r));
        }

        return reverseSet(afterOpened).stream().toList();
    }

    static private Set<String> iteration(String s) {
        Set<String> current = new HashSet<>();
        current.add(s);

        int n = s.length();
        int opens = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                opens++;
            } else if (s.charAt(i) == ')') opens--;

            if (opens == -1) {
                current = removeBrackets(current, i - diff);
                diff++;
                opens = 0;
            }
        }
        return current;
    }

    static private Set<String> removeBrackets(Set<String> current, int i) {
        Set<String> next = new HashSet<>();
        for (String sb : current) {
            int index = i;
            while (index >= 0) {
                if (sb.charAt(index) == ')' && (index == 0 || sb.charAt(index - 1) != ')')) {
                    StringBuilder sbCopy = new StringBuilder(sb);
                    sbCopy.deleteCharAt(index);
                    next.add(sbCopy.toString());
                }
                index--;
            }
        }
        return next;
    }

    static private String rev(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                sb.append(')');
            } else if (c == ')') {
                sb.append('(');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static private Set<String> reverseSet(Set<String> set) {
        Set<String> reversedSet = new HashSet<>();
        for (String s : set) {
            reversedSet.add(rev(s));
        }
        return reversedSet;
    }

}

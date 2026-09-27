package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1190ReverseSubstringsBetweenEachPairofParentheses {
   static public String reverseParentheses(String s) {
        int n = s.length();
        StringBuilder sCopy = new StringBuilder(s);
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (sCopy.charAt(i) == '(') {
                deq.add(i);
            } else if (sCopy.charAt(i) == ')') {
                int j = deq.removeLast();
                StringBuilder curr = new StringBuilder(sCopy.substring(j, i));
                curr.reverse();
                sCopy.replace(j,i, String.valueOf(curr));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i =0;i <n;i++){
            char c = sCopy.charAt(i);
            if(c != '(' && c != ')'){
             ans.append(c);
            }
        }
        return ans.toString();
    }
}

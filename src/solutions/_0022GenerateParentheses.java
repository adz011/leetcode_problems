package solutions;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {
    static List<String> list = new ArrayList<>();
    static public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, 0, n, 0);
        return list;
    }

    static private void helper(StringBuilder sb, int openBracketCount, int closeBracketCount, int n, int currLength){
        if(currLength == n * 2){
            list.add(sb.toString());
        }else{
            if(openBracketCount < n){
                sb.append('(');
                helper(sb, openBracketCount+1, closeBracketCount, n, currLength + 1);
                sb.deleteCharAt(currLength);
            }

            if(openBracketCount > closeBracketCount){
                sb.append(')');
                helper(sb, openBracketCount, closeBracketCount +1, n, currLength + 1);
                sb.deleteCharAt(currLength);
            }
        }
    }
}

package solutions;

import java.util.ArrayList;
import java.util.List;

public class _1021RemoveOutermostParentheses {
    static public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int opens = 0, left = 0;
        for(int i =0; i<n; i++){
            if(s.charAt(i) == '('){
                opens++;
            }else opens--;
            if(opens == 0){
                ans.append(s, left + 1, i);
                left = i + 1;
            }
        }
        return ans.toString();
    }
}

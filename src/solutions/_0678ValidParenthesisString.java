package solutions;

public class _0678ValidParenthesisString {
    static public boolean checkValidString(String s) {
        int n = s.length(), lo =0, hi = 0;
        for(int i =0; i<n; i++){
            if(s.charAt(i) =='('){
                lo++;
                hi++;
            }else if(s.charAt(i) == ')'){
                lo--;
                hi--;
            }else{
                lo--;
                hi++;
            }
            if(hi < 0) return false;
            if(lo < 0) lo = 0;
        }
        return lo == 0;
    }
}

package solutions;

public class _1541MinimumInsertionsToBalanceaParanthesesString {
    static public int minInsertions(String s) {
        int n = s.length();
        int pendingClose = 0;
        int insertions= 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                pendingClose+=2;
            } else {
                if(pendingClose == 0){
                    pendingClose+=2;
                    insertions++;
                }
                if(i+1 <n && s.charAt(i+1) == ')'){
                    i++;
                }else{
                    insertions++;
                }
                pendingClose-=2;
            }
        }
        return insertions + pendingClose;
    }
}

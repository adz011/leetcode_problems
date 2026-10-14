package solutions;

public class _0038CountAndSay {
    static public String countAndSay(int n) {
        String s = "1";
        int i = 1;
        while(i < n){
            s = RLE(s);
            i++;
        }
        return s;
    }

    static private String RLE(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0, j = i; i < n; i++) {
            if(i < n -1 && s.charAt(i) == s.charAt(i+1)) continue;
            int x = s.charAt(i) - '0';
            sb.append(i - j + 1);
            sb.append(x);
            j = i+1;
        }
        return sb.toString();
    }

}

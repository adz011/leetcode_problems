package solutions;

public class _008StringtoIntegeratoi {
    static public int myAtoi(String s) {
        final int MINUS_INFINITY = -2147483648;
        final int INFINITY = 2147483647;
        long digit = 0, n = s.length();
        int si = 0, li;
        boolean isPositive = true;
        while (si < n && s.charAt(si) == ' ') si++;
        if (si < n && (s.charAt(si) == '-' || s.charAt(si) == '+')) {
            if (s.charAt(si) == '-') isPositive = false;
            si++;
        }
        li = si;

        while (li < n && s.charAt(li) >= '0' && s.charAt(li) <= '9') {
            if(digit > INFINITY){
                break;
            }
            digit *= 10;
            digit += s.charAt(li) - '0';
            li++;
        }
        ;
        return (int) (isPositive ? Math.min(INFINITY, digit) : Math.max(-digit, MINUS_INFINITY));
    }
}

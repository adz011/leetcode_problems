package solutions;

public class _3863MinimumOperationsToSortAString {
    static public int minOperations(String s) {
        int n = s.length();
        if (n == 1) return 0;
        if (n == 2 && s.charAt(0) > s.charAt(1)) return -1;
        if (n == 2) return 0;

        char cFirst = s.charAt(0), cLast = s.charAt(n - 1);
        boolean isFirstSmallest = true, isLastBiggest = true, isSorted = true;
        boolean isFirstStrictBiggest = true, isLastStrictSmallest = true;
        for (int i = 1; i < n -1 ; i++) {
            char c = s.charAt(i);
            if(cFirst > c) isFirstSmallest = false;
            if(cLast < c) isLastBiggest = false;
            if(c < s.charAt(i-1)) isSorted = false;
            if(cFirst <= c) isFirstStrictBiggest = false;
            if(cLast >= c) isLastStrictSmallest = false;
        }
        if(cLast < cFirst){
            if(isFirstStrictBiggest && isLastStrictSmallest) return 3;
            else return 2;
        }

        if(isSorted && isFirstSmallest && isLastBiggest) return 0;
        if (!isFirstSmallest && !isLastBiggest) return 2;
        else return 1;
    }
}

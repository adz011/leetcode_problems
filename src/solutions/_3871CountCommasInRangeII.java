package solutions;

public class _3871CountCommasInRangeII {
    static public long countCommas(long n) {
        long commas = 0;
        long threshold = 1000;
        while (threshold <= n) {
            commas += n - threshold + 1;
            if (threshold > n / 1000) {
                break;
            }
            threshold *= 1000;
        }
        return commas;
    }
}

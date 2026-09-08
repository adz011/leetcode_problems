package solutions;

public class _3870CountCommasInRange {
    static public int countCommas(int n) {
        long commas = 0;
        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            commas += n - threshold + 1;
        }
        return (int) commas;
    }
}

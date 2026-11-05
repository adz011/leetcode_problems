package solutions;

public class _3622CheckDivisibilityByDigitSumAndProduct {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int nCopy = n;
        while (nCopy > 0) {
            int curr = nCopy % 10;
            sum += curr;
            product *= curr;
            nCopy /= 10;
        }
        return n % (sum + product) == 0;
    }
}

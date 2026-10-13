package solutions;

public class _4078ThreeFibonacciSum {
    static public boolean threeFibonacciSum(int n) {
        if(n % 2 == 1) return false;
        int halfN = n / 2;
        int preFib = 1;
        int curFib = 2;
        while(halfN >= curFib){
            if(halfN == curFib) return true;
            int x = preFib;
            preFib = curFib;
            curFib += x;
        }
        return false;
    }
}

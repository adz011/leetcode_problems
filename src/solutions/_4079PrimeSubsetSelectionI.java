package solutions;

import java.util.ArrayList;
import java.util.List;

public class _4079PrimeSubsetSelectionI {
    static public List<Integer> maxPrimes(int n, int s) {
        int sum = 0;
        List<Integer> primes = new ArrayList<>();
        boolean[] composite = new boolean[n+1];
        for(int i = 2; i<= n; i++){
            if(!composite[i]){
                if(sum + i > s) break;
                primes.add(i);
                sum+=i;
                for(long j = (long) i * i; j <=n; j+=i){
                    composite[(int) j] = true;
                }
            }
        }
        return primes;
    }
}

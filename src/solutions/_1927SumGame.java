package solutions;

public class _1927SumGame {
    public boolean sumGame(String num) {
        int sumL = 0, sumR = 0, qR = 0, qL = 0,  n = num.length();
        for(int i =0; i < n >> 1; i++){
            if(num.charAt(i) == '?'){
                qL++;
            }else sumL += num.charAt(i) - 48;
        }

        for(int i =n >> 1; i < n; i++){
            if(num.charAt(i) == '?'){
                qR++;
            }else sumR += num.charAt(i) - 48;
        }

        return (qR + qL) % 2 == 1 || sumR - sumL != 9 * Math.ceil((qL - qR) / (double) 2);
        }
}

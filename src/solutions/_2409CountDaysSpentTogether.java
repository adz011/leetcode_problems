package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2409CountDaysSpentTogether {
    static int[] monthDays;

    static public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days = 0;
        buildHashMap();
        if (leaveAlice.compareTo(arriveBob) >=0 && arriveAlice.compareTo(leaveBob) <=0) {
            String leaveMin = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
            String arriveMax = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
            int mMin = Integer.parseInt(arriveMax.substring(0,2));
            int mMax = Integer.parseInt(leaveMin.substring(0,2));
            int dMin = Integer.parseInt(arriveMax.substring(3,5));
            int dMax = Integer.parseInt(leaveMin.substring(3,5));
            int diff = mMax - mMin;
            while(diff > 0){
                days+=monthDays[mMax-diff];
                diff--;
            }
            days += dMax - dMin + 1;
        }
        return days;
    }

    static private void buildHashMap() {
        monthDays = new int[13];
        monthDays[1] = 31;
        monthDays[2] = 28;
        monthDays[3] = 31;
        monthDays[4] = 30;
        monthDays[5] = 31;
        monthDays[6] = 30;
        monthDays[7] = 31;
        monthDays[8] = 31;
        monthDays[9] = 30;
        monthDays[10] = 31;
        monthDays[11] = 30;
        monthDays[12] = 31;

    }

}

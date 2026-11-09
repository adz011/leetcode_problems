package solutions;

import java.util.*;

public class _1606FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        List<Integer> busiestServers = new ArrayList<>();
        for (int j = 0; j < k; j++) free.add(j);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {endTime, id}
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                free.add(busy.poll()[1]);
            }
            if (free.isEmpty()) continue;
            Integer s = free.ceiling(i % k);
            if (s == null) s = free.first();
            free.remove(s);
            busy.offer(new int[]{arrival[i] + load[i], s});
            count[s]++;
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
            if(!busiestServers.isEmpty() && count[busiestServers.getFirst()] < max) busiestServers.clear();
            if (count[i] == max) busiestServers.add(i);
        }
        return busiestServers;
    }
}

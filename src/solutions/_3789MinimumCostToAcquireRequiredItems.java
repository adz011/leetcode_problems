package solutions;

public class _3789MinimumCostToAcquireRequiredItems {
    static public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int needBoth = Math.min(need1, need2);
        long totalCost = 0;

        totalCost = (long) Math.min(costBoth, cost1 + cost2) * needBoth;

        if (need1 < need2) totalCost += (long) Math.min(costBoth, cost2) * (need2 - need1);
        else if (need1 > need2) totalCost += (long) Math.min(costBoth, cost1) * (need1 - need2);

        return totalCost;
    }

}

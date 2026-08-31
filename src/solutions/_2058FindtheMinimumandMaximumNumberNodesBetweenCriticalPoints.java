package solutions;

public class _2058FindtheMinimumandMaximumNumberNodesBetweenCriticalPoints {
     // Definition for singly-linked list.
      static public class ListNode {
          public int val;
          public ListNode next;
          public ListNode() {}
          public ListNode(int val) { this.val = val; }
          public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode previousN, currentN;
        int firstCritIndex = -1, latestCritIndex = -1, count = 1, longestDistance = -1, shortestDistance = Integer.MAX_VALUE;
        previousN = head;
        currentN = head.next;
        boolean isBigger = false, halfCritical = false;
        while(currentN!=null){
            if(!halfCritical){
                if(previousN.val < currentN.val){
                    isBigger = true;
                    halfCritical = true;
                }else if(previousN.val > currentN.val){
                    isBigger = false;
                    halfCritical = true;
                }
           }else{
                if(previousN.val < currentN.val){
                    if(!isBigger){
                        if(firstCritIndex > -1){
                            longestDistance = count - firstCritIndex;
                        }else{
                            firstCritIndex = count;
                        }
                        if(latestCritIndex > -1){
                            shortestDistance = Math.min(shortestDistance, count - latestCritIndex);
                        }
                        latestCritIndex = count;
                        isBigger = true;
                    }
                }else if (previousN.val > currentN.val){
                    if(isBigger){
                        if(firstCritIndex > -1){
                            longestDistance = count - firstCritIndex;
                        }else{
                            firstCritIndex = count;
                        }
                        if(latestCritIndex > -1){
                            shortestDistance = Math.min(shortestDistance, count - latestCritIndex);
                        }
                        latestCritIndex = count;
                        isBigger = false;
                    }
                }else halfCritical = false;
            }
            count++;
            previousN = currentN;
            currentN = currentN.next;
        }
        return new int[]{shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance, longestDistance};
    }
}

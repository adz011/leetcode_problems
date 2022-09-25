package Java;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode current = l3;
        int tenth = 0;
        int sum;
        while(l1 != null || l2 != null || tenth == 1){
            sum = ((l1 != null) ? l1.val : 0) + (((l2 != null) ? l2.val : 0)) + tenth;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(sum >=10) tenth = 1;
            else tenth = 0;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        } return l3.next;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        for(int i = 0; i< 3; i++){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
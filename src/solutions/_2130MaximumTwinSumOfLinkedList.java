package solutions;

public class _2130MaximumTwinSumOfLinkedList {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static public int pairSum(ListNode head) {
        int n = 1, max = 0;
        ListNode tail = head;
        ListNode curr = head;
        while (curr.next != null) {
            tail = new ListNode(curr.next.val, tail);
            n++;
            curr = curr.next;
        }

        curr = head;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, tail.val + curr.val);
            curr = curr.next;
            tail = tail.next;
        }
        return max;
    }

    static public int pairSumNoExtraNodes(ListNode head) {
        int n = 0, max = 0, half;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        curr = head;
        half = n / 2;
        int[] values = new int[half];
        for (int i = 0; i < half; i++) {
            values[i] = curr.val;
            curr = curr.next;
        }
        for (int j = half - 1; j >= 0; j--) {
            max = Math.max(max, values[j] + curr.val);
            curr = curr.next;
        }
        return max;
    }
}
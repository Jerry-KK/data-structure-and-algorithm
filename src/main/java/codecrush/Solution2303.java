package codecrush;

public class Solution2303 {

    public ListNode removeLastKth(ListNode head, int k) {
        ListNode n = new ListNode(-1, head);
        ListNode n2 = n;
        while (k > 0) {
            n2 = n2.next;
            --k;
        }
        while (n2.next != null) {
            n2 = n2.next;
            n = n.next;
        }
        if (n.next == head)
            return head.next;
        n.next = n.next.next;
        return head;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

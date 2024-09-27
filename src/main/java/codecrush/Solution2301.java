package codecrush;

public class Solution2301 {

    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
        }
        return n2.next == null ? n1 : n1.next;

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

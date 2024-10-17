package codecrush;

public class Solution2307 {

    public ListNode reverse(ListNode head){
        if (head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode next = head.next;
            head.next = null;
            next.next = head;
            return next;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        n1.next = null;
        while (n2.next != null) {
            ListNode tmp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = tmp;
        }
        n2.next = n1;
        return n2;
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

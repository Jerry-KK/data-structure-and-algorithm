package codecrush;

public class Solution2302 {

    public ListNode findLastKth(ListNode head, int k) {
        ListNode n = head;
        ListNode n2 = head;
        for(; k>1 ; k--)
            n = n.next;
        while (n.next != null) {
            n = n.next;
            n2 = n2.next;
        }
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

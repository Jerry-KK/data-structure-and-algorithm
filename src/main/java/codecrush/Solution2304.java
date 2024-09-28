package codecrush;

public class Solution2304 {

    public static void main(String[] args) {
        //2 6 3 4 9
        //2
        ListNode a = new ListNode(9, null);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(6, c);
        ListNode head = new ListNode(2, d);
        Solution2304 body = new Solution2304();
        ListNode listNode = body.rotate(head, 10);
        System.out.println();
    }

    public ListNode rotate(ListNode head, int k) {
        if (k == 0)
            return head;
        ListNode n = head;
        ListNode n2 = head;
        int tar = k;
        while (n2.next != null && k > 0) {
            n2 = n2.next;
            --k;
        }
        if (k > 0) {
            int l = tar - k + 1;
            tar %= l;
            n2 = head;
            if (tar == 0) {
                return head;
            }
            while (tar > 0) {
                n2 = n2.next;
                --tar;
            }
        }
        while (n2.next != null) {
            n2 = n2.next;
            n = n.next;
        }
        ListNode newHead = n.next;
        n.next = null;
        n2.next = head;
        return newHead;
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

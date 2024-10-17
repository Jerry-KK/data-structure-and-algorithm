package codecrush;

import java.util.HashSet;
import java.util.Set;

public class Solution2305 {

    public ListNode removeDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode node = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (set.contains(nextNode.val)) {
                node.next = nextNode.next;
                nextNode = nextNode.next;
                continue;
            }
            set.add(nextNode.val);
            node = nextNode;
            nextNode = nextNode.next;
        }
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

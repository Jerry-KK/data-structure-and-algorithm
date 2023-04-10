package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lethe
 * @date 2023/4/10 11:44
 */
public class Leetcode1019 {

    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        int l = 1;
        while ((node = node.next) != null && ++l > 0);
        int[] ret = new int[l];
        Stack<Integer> valStack = new Stack<>();
        Stack<Integer> idxStack = new Stack<>();
        int idx= 0;
        node = head;
        while (node != null) {
            int nextVal = node.val;
            while (!valStack.isEmpty() && valStack.peek() < nextVal) {
                valStack.pop();
                Integer popIdx = idxStack.pop();
                ret[popIdx] = nextVal;
            }
            valStack.push(node.val);
            idxStack.push(idx);
            node = node.next;
            ++idx;
        }
        return ret;
    }


    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

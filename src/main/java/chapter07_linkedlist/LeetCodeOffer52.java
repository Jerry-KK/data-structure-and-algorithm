package chapter07_linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author koujn
 * @date 2021/7/21 16:03
 */
public class LeetCodeOffer52 {
    public static void main(String[] args) {

        ListNode a5 = new ListNode(5,null);
        ListNode a4 = new ListNode(4,a5);
        ListNode a3 = new ListNode(8,a4);
        ListNode a2 = new ListNode(1,a3);
        ListNode a1 = new ListNode(4,a2);

        ListNode b3 = new ListNode(1,a3);
        ListNode b2 = new ListNode(0,b3);
        ListNode b1 = new ListNode(5,b2);

        ListNode intersectionNode = getIntersectionNode4(a1, b1);
        System.out.println(intersectionNode.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int sizaA = 0;
        int sizeB = 0;
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            sizaA++;
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            sizeB++;
            set.add(headB);
            headB = headB.next;
        }
        int c = sizaA + sizeB - set.size();
        if(c == 0) {
            return null;
        }
        ListNode node = sizaA < sizeB ? nodeA : nodeB;
        int n = sizaA < sizeB ? sizaA-c : sizeB-c;
        for (int i = 0; i < n ; i++) {
            node = node.next;
        }
        return node;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int sizaA = 0;
        int sizeB = 0;
        while (headA != null) {
            sizaA++;
            headA = headA.next;
        }
        while (headB != null) {
            sizeB++;
            headB = headB.next;
        }
        if(sizaA > sizeB ) {
            for (int i = 0; i < sizaA - sizeB ; i++) {
                nodeA = nodeA.next;
            }
        }else {
            for (int i = 0; i < sizeB - sizaA; i++) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != null) {
            if(nodeA.equals(nodeB)) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        while (headA != null) {
            headA = headA.next;
            nodeA = nodeA.next;
        }
        while (headB != null) {
            headB = headB.next;
            nodeB = nodeB.next;
        }
        while (nodeA != null) {
            if(nodeA.equals(nodeB)) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (headA != headB) {
            headA = headA == null ? nodeB : headA.next;
            headB = headB == null ? nodeA : headB.next;
        }
        return headA;
    }
}

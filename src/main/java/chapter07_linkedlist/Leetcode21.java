package chapter07_linkedlist;

/**
 * @author koujn
 * @date 2021/7/20 14:11
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Leetcode21 {
    public static void main(String[] args) {

        ListNode l13 = new ListNode(4,null);
        ListNode l12 = new ListNode(2,l13);
        ListNode l11 = new ListNode(1,l12);

        ListNode l23 = new ListNode(4,null);
        ListNode l22 = new ListNode(3,l23);
        ListNode l21 = new ListNode(1,l22);

        ListNode node = mergeTwoLists(l11, l21);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode res = new ListNode();
        ListNode first = new ListNode(0,res);
        do {
            ListNode node;
            if(l1.val <= l2.val) {
                node =  new ListNode(l1.val);
                l1 = l1.next;

            }else {
                node =  new ListNode(l2.val);
                l2 = l2.next;
            }
            res.next = node;
            res = res.next;
        }while (l1!= null && l2!= null);
        ListNode l3 = l1 == null ? l2 : l1;
        do{
            ListNode node =  new ListNode(l3.val);
            l3 = l3.next;
            res.next = node;
            res = res.next;
        }while (l3 != null);
        return first.next.next;
    }

    private static void addNode(ListNode l,ListNode res) {
        ListNode node3 =  new ListNode(l.val);
        l = l.next;
        res.next = node3;
        res = res.next;
    }
}


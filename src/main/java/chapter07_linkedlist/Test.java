package chapter07_linkedlist;

/**
 * @author koujn
 * @date 2021/7/20 15:22
 */
public class Test {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(6,null);
        ListNode l12 = new ListNode(5,l13);
        ListNode l11 = new ListNode(2,l12);

        ListNode l23 = new ListNode(4,l11);
        ListNode l22 = new ListNode(3,l23);
        ListNode l21 = new ListNode(1,l22);


        //问题1
        /*ListNode node = reversal(l21);
        while (node != null) {
            System.out.println(node.val);
            node= node.next;
        }*/

        //问题2
        //l11.next = l23;
        //System.out.println(hasRing(l21));
        /*l23.next = l21;
        l23.next = null;
        System.out.println(hasCycle(l21));*/

        //问题4
        /*deleteReciprocal(l21, 3);
        while (l21 != null) {
            System.out.println(l21.val);
            l21= l21.next;
        }*/
        l23.next = null;
        ListNode node = removeNthFromEnd(l21, 2);
        while (node != null) {
            System.out.println(node.val);
            node= node.next;
        }

        //问题5
        /*ListNode intermediateNode = middleNode(l21);
        System.out.println(intermediateNode.val);*/


    }

    //LeetCode 206
    //1.单链表反转
    public static ListNode reversal(ListNode node) {
        ListNode target = new ListNode(node.val,null);
        while (node.next != null) {
            node = node.next;
            ListNode temp = new ListNode(node.val,target);
            target = temp;
        }
        return target;
    }

    //LeetCode 141
    //2.链表中环的检测
    public static boolean hasRing(ListNode node) {
        if(node == null || node.next == null || node.next.next == null) {
            return false;
        }
        ListNode step1 = node.next;
        ListNode step2 = node.next.next;
        do {
            if(step1 == step2) {
                return true;
            }
            step1 = step1.next;
            step2 = step2.next.next;
        }while (step2 != null);
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode step1 = head.next;
        ListNode step2 = head.next.next;
        while (step2 != null && step2.next != null) {
            if(step1 == step2) {
                return true;
            }
            step1 = step1.next;
            step2 = step2.next.next;
        }
        return false;
    }

    //3.两个有序的链表的合并
    //Leetcode21

    //LeetCode 19
    //4.删除链表倒数第n个节点
    public static void deleteReciprocal(ListNode node,int n) {
        ListNode temp = node;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        //长度为n时直接返回第二个节点，因为这里的链表没有头指针（头节点），所有抛弃第一个node（第一个node删不掉）存在内存泄露问题
        if(node.next == null) {
            temp = temp.next;
        }
        while (node.next != null){
            node = node.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode first = head;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        if(head == null) {
            return temp.next;
        }
        while (head.next != null){
            head = head.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return first;
    }

    //LeetCode 876
    //5.求链表的中间节点(有两个中间节点返回第一个)
    public static ListNode getIntermediateNode(ListNode node) {
        if(node == null || node.next == null || node.next.next == null) {
            if(node == null) {
                return null;
            }else {
                return node;
            }
        }
        ListNode step1 = node.next;
        ListNode step2 = node.next.next;
        while (step2.next != null && step2.next.next != null) {
            step1 = step1.next;
            step2 = step2.next.next;

        }
        return step1;
    }

    //LeetCode 876
    //5.求链表的中间节点(有两个中间节点返回第二个)
    public static ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode step1 = head.next;
        ListNode step2 = head.next.next;
        while (step2 != null && step2.next != null) {
            step1 = step1.next;
            step2 = step2.next.next;

        }
        return step1;
    }
}

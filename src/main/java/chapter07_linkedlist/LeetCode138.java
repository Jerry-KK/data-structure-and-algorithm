package chapter07_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/7/22 10:16
 */
public class LeetCode138 {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node a = n1;
        while (a != null) {
            myPrint(a);
            a = a.next;
        }
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        Node node = copyRandomList(n1);
        while (node != null) {
            myPrint(node);
            node = node.next;
        }

    }
    private static void myPrint(Node n) {
        System.out.println("val: " +  n.val + ", Node.toSting: " + n.toString());
        if(n.random != null) {
            System.out.println("random.val: " + n.random.val + ", random.toSting: " + n.random.toString());
        }else {
            System.out.println("null");
        }
        System.out.println("---------------------");
    }

    public static Node copyRandomList(Node head) {
        Node first = new Node(-1);
        first.next = head;
        Node a = new Node(-1);
        Node b = new Node(-1);
        Node c = new Node(-1);
        b.next = a;
        c.next = a;
        Map<Node,Node> map = new HashMap<>();
        while (head!= null) {
            Node node = new Node(head.val);
            map.put(head,node);
            head = head.next;
            a.next = node;
            a = a.next;
        }
        first = first.next;
        b = b.next;
        while (first != null) {
            b = b.next;
            if(first.random == null) {
                b.random = null;
            }else {
                b.random = map.get(first.random);
            }
            first = first.next;
        }
        return c.next.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

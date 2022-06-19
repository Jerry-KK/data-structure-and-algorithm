package leetcode;

/**
 * @author lethe
 * @date 2022/6/18 13:31
 */
public class LeetcodeOffer029 {

    public Node insert(Node head, int insertVal) {
        Node t = new Node(insertVal);
        if(head == null) {
            t.next = t;
            head = t;
        }else if(head.next == head) {
            head.next = t;
            t.next = head;
        }else {
            Node p = head, n = p.next;
            while ( p.val <= n.val && n != head) {
                p = n;
                n = n.next;
            }
            if(insertVal >= p.val || insertVal <= n.val) {
                p.next = t;
                t.next = n;
            } else {
                while (true) {
                    if(p.val <= insertVal && insertVal <= n.val) {
                        p.next = t;
                        t.next = n;
                        break;
                    }
                    p = n;
                    n = n.next;
                }
            }
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}

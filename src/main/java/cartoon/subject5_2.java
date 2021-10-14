package cartoon;

/**
 * @author koujn
 * @date 2021/10/9 16:29
 */
public class subject5_2 {

    /**
     * 判断是否有环
     * @param head  链表头节点
     * @return
     */
    public static boolean isCycle(Node head) {
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n2 != null) {
            if(n1 == n2)
                return true;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return false;
    }

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

}

package chapter06_linkedlist;

/**
 * @author koujn
 * @date 2021/7/20 9:17
 */
public class MyLinkedList {

    public Node head;
    public Node end;

    public MyLinkedList() {
        head = new Node();
        end = new Node();
    }

    public void add(char val) {
        //构建要插入的node节点
        Node node = new Node();
        node.data = val;
        Node nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = node;
        node.previous = nextNode;
        end.next = node;
    }

    public Node get(char val) {
        Node node = head.next;
        while (node.next != null) {
            if(node.data == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }





}

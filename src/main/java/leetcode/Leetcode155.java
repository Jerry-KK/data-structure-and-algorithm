package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lethe
 * @date 2021/11/11 23:53
 */
public class Leetcode155 {
    public static void main(String[] args) {
        MinStack stack = new Leetcode155().new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());

    }

    class MinStack {
        Node head;
        int n;

        public MinStack() {
            head = new Node();
            n = 0;
        }

        public void push(int val) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.num = ++n;
            Node node = head;
            while (node.next != null && node.next.val <= val) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }

        public void pop() {
            Node pp = head;
            Node p = head.next;
            while (p.num != n) {
                pp = p;
                p = p.next;
            }
            pp.next = p.next;
            --n;
        }

        public int top() {
            Node p = head.next;
            while (p.num != n)
                p = p.next;
            return p.val;
        }

        public int getMin() {
            return head.next.val;
        }
    }

    class Node{
        private int val;
        private int num;
        private Node next;
    }


    class AnsMinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public AnsMinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            minStack.add(Integer.MAX_VALUE);
        }

        public void push(int val) {
           stack.push(val);
           minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
           stack.pop();
           minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

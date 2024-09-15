package codecrush;

import java.util.*;

public class Solution2202 {

    public static void main(String[] args) {
        System.out.println(removeDigits(1542249,3));
        System.out.println(removeDigits(10434,1));
        System.out.println(removeDigits(0,1));
    }

    public static int removeDigits(int num, int k) {
        if (num == 0)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(stack.pop());
        while (!stack.isEmpty() && k > 0) {
            if (deque.peekLast() > stack.peek()) {
                deque.pollLast();
                --k;
            }
            deque.offerLast(stack.pop());
        }
        while (!stack.isEmpty()) {
            deque.offerLast(stack.pop());
        }
        while (k > 0 && !deque.isEmpty()) {
            deque.pollLast();
            --k;
        }
        while (!deque.isEmpty()) {
            res *= 10;
            res += deque.pollFirst();
        }
        return res;
    }

}

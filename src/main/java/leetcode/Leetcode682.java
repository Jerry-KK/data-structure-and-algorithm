package leetcode;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/12 10:22
 */
public class Leetcode682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int a,b;
        for (int i = 0; i < ops.length; i++) {
            if("+".equals(ops[i])) {
                b = stack.pop();
                a = stack.peek() + b;
                stack.push(b);
                stack.push(a);
            }else if("D".equals(ops[i])) {
                stack.push(2 * stack.peek());
            } else if("C".equals(ops[i])) {
                stack.pop();
            }else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        int sum = 0;
        /*while (!stack.isEmpty()) {
            sum+=stack.pop();
        }*/
        for (int score : stack)
            sum+=score;
        return sum;
    }
}

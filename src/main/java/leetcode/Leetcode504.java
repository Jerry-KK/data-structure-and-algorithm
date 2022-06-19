package leetcode;

import java.util.Stack;

/**
 * @author lethe
 * @date 2022/3/7 11:35
 */
public class Leetcode504 {

    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        if(num < 0) {
            sb.append("-");
            num = 0 - num;
        }
        while (num >= 7) {
            int v = num % 7;
            num/=7;
            stack.push(v);
        }
        sb.append(num);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}

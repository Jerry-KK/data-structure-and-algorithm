package leetcode;

import java.util.Stack;

/**
 * @author lethe
 * @date 2021/11/11 23:36
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        char[] stack = new char[arr.length];
        int n = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c == '}') {
                if(n == -1)
                    return false;
                else if(stack[n] == '{')
                    --n;
                else
                   stack[++n] = '}';
            }else if(c == ']') {
                if(n == -1)
                    return false;
                else if(stack[n] == '[')
                    --n;
                else
                    stack[++n] = ']';
            }else if(c == ')') {
                if(n == -1)
                    return false;
                else if(stack[n] == '(')
                    --n;
                else
                    stack[++n] = ')';
            }else {
                stack[++n] = c;
            }
        }
        return n == -1;
    }
}

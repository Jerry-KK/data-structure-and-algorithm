package leetcode.efficientwinning;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lethe
 * @date 2022/3/9 18:31
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (char c:s.toCharArray()) {
            if(pairs.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}

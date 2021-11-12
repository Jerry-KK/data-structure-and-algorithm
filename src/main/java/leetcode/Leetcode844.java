package leetcode;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/12 9:34
 */
public class Leetcode844 {

    public static void main(String[] args) {
        Leetcode844 body = new Leetcode844();
        boolean b = body.backspaceCompare("xywrrmp"
                ,"xywrrmu#p");
        System.out.println(b);
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                if (!s1.isEmpty())
                    s1.pop();
            }
            else
                s1.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == '#') {
                if(!s2.isEmpty())
                    s2.pop();
            }
            else
                s2.push(t.charAt(i));
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Character c1 = s1.pop();
            Character c2 = s2.pop();
            if(c1 != c2)
                return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}

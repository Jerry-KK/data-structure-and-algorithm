package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lethe
 * @date 2022/9/7 0:01
 */
public class Leetcode828 {
    public static void main(String[] args) {
        Leetcode828 body = new Leetcode828();
        int res = body.uniqueLetterString("AAC");
        System.out.println(res);
    }

    Map<Character, Integer> map = new HashMap<>();
    int sum = 0;
    String s;
    int n = 0;

    public int uniqueLetterString(String s) {
        this.s = s;
        helper(0);
        return sum;
    }

    private void helper(int idx) {
        if(idx < s.length()) {
            Character c = s.charAt(idx);
            map.putIfAbsent(c,0);
            helper(idx + 1);
            int i = map.get(c);
            if(i == 0)
                ++n;
            else if(i == 1)
                --n;
            map.put(c, map.get(c)+1);
            sum += n;
            helper(idx+1);
            i = map.get(c);
            if(i == 2)
                ++n;
            else if(i == 1)
                --n;
            map.put(c, map.get(c)-1);
        }
    }


}

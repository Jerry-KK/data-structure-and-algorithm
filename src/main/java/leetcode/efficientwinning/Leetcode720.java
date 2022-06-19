package leetcode.efficientwinning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2022/3/12 13:15
 */
public class Leetcode720 {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        int i = 0;
        String ans = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String s:words) {
            String suf = s.substring(0, s.length()-1);
            if(set.contains(suf)) {
                if(s.length() > i) {
                    ans = s;
                    i = s.length();
                }
                set.add(s);
            }
        }
        return ans;
    }

}

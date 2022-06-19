package leetcode.efficientwinning;

import java.util.Stack;

/**
 * @author lethe
 * @date 2022/3/13 22:36
 */
public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2 == 0)
            return 0;
        if(l1 >= l2) {
            int l = l1-l2;
            for (int i = 0; i <= l; i++) {
                boolean flag = true;
                for (int j = 0; j < l2; j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    return i;
            }
        }
        return -1;
    }

}

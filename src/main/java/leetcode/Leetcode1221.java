package leetcode;

/**
 * @author koujn
 * @date 2021/9/7 9:15
 */
public class Leetcode1221 {
    public int balancedStringSplit(String s) {
        char[] a = s.toCharArray();
        int res = 0;
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 'R') {
                r++;
            }else {
                r--;
            }
            if(r == 0) {
                res++;
                r = 0;
            }
        }
        return res;
    }
}

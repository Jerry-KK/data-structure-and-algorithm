package leetcode;

/**
 * @author koujn
 * @date 2021/12/1 10:28
 */
public class Leetcode1446 {

    public int maxPower(String s) {
        int max = 1;
        int i = 1;
        int c = s.charAt(0);
        int n = 1;
        while (i < s.length()) {
           if(s.charAt(i) == c) {
               ++n;
           }else {
               max = Math.max(max,n);
               n = 1;
               c = s.charAt(i);
           }
           ++i;
        }
        return Math.max(max,n);
    }

    public int maxPower2(String s) {
        int max = 1;
        int i = 1;
        int j = 0;
        while (i < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                max = Math.max(max,i-j);
                j = i;
            }
            ++i;
        }
        return Math.max(max,i-j);
    }

}

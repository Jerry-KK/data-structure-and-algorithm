package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/12 13:41
 */
public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        Integer n = 0;
        int size = 0;
        for (int j = 0,i = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            int v = 1<<(ch-'0');
            if((n & v) == 0) {
                size = Math.max(size,j-i+1);
                n^=v;
            }else {
                while ((n & v) != 0 ) {
                    char ch2 = s.charAt(i);
                    int v2 = 1<<(ch2-'0');
                    n -= v2;
                    ++i;
                }
            }
        }
        return size;
    }

}

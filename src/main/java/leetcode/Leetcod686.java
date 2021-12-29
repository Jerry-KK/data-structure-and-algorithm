package leetcode;

/**
 * @author lethe
 * @date 2021/12/22 16:16
 */
public class Leetcod686 {

    public int repeatedStringMatch(String a, String b) {
        if(b.equals(""))
            return 0;
        if(b.length() < a.length())
            return -1;
        int i = 0;
        int j = 0;
        char start = b.charAt(0);
        for (int k = 0; k < a.length(); k++) {
            if(a.charAt(k) == start) {
                for (int l = k+1,m = 1; l < a.length(); l++) {
                    if(a.charAt(l) == b.charAt(m)) {

                    }
                }
            }
        }
        return -1;
    }
}
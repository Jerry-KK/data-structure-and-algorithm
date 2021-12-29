package leetcode;

/**
 * @author lethe
 * @date 2021/12/18 13:34
 */
public class Leetcode1816 {

    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                if(--k == 0)
                    return s.substring(0,i);
        }
        return s;
    }

}

package leetcode;

/**
 * @author lethe
 * @date 2023/5/25 11:54
 */
public class Leetcode2451 {

    public String oddString(String[] words) {
        int l = words[0].length(), n = words.length;
        for (int i = 1; i < l; i++) {
            int t0 = (int)words[0].charAt(i) -  (int)words[0].charAt(0);
            int t1 = (int)words[1].charAt(i) -  (int)words[1].charAt(0);
            if(t0 != t1) {
                return (int)words[2].charAt(i) -  (int)words[2].charAt(0) == t0 ? words[1] : words[0];
            } else {
                for (int j = 2; j < n; j++)
                    if((int)words[j].charAt(i) -  (int)words[j].charAt(0) != t0)
                        return words[j];
            }
        }
        return null;
    }

}

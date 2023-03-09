package leetcode;

/**
 * @author lethe
 * @date 2023/3/9 12:38
 */
public class Leetcode2379 {

    public int minimumRecolors(String blocks, int k) {
        int n = 0;
        for (int i = 0; i < k; i++)
            if(blocks.charAt(i) == 'W')
                ++n;
        int r = n;
        for (int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'W')
                ++n;
            if(blocks.charAt(i-k) == 'W')
                --n;
            r = Math.min(r, n);
        }
        return r;
    }

}

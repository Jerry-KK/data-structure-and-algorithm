package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lethe
 * @date 2022/9/3 15:46
 */
public class Leetcode646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = 1;
        int e = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] <= e && pairs[i][1] <e) {
                e = pairs[i][1];
            }else if(pairs[i][0] > e) {
                ++n;
                e = pairs[i][1];
            }
        }
        return n;
    }

    //	9 ms	41.5 MB
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = 1;
        for (int i = 1, e = pairs[0][1]; i < pairs.length; i++)
            if(pairs[i][1] <e || pairs[i][0] > e  && ++n > 0)
                e = pairs[i][1];
        return n;
    }

}

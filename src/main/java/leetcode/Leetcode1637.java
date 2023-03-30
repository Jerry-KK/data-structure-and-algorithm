package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lethe
 * @date 2023/3/30 20:08
 */
public class Leetcode1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        for (int i = 1; i < points.length; i++)
            res = Math.max(res, points[i][0]- points[i-1][0]);
        return res;
    }

}

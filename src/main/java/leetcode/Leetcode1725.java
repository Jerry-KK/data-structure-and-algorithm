package leetcode;

/**
 * @author lethe
 * @date 2022/2/4 12:14
 */
public class Leetcode1725 {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 1,sum = 0;
        for (int[] arr: rectangles) {
            int l = Math.min(arr[0],arr[1]);
            if(l > maxLen) {
                maxLen = l;
                sum = 1;
            }else if(l == maxLen) {
                ++sum;
            }
        }
        return sum;
    }

}

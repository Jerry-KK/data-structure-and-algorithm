package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/10 21:51
 */
public class Leetcode279 {

    public int numSquares(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min,arr[i-j*j]);
            }
            arr[i] = min+1;
        }
        return arr[n];
    }

}

package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/7 19:09
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int[] arr = {2,1};
        for (int i = 3; i < n; i++) {
            arr[i%2] = arr[0] + arr[1];
        }
        return arr[0] + arr[1];
    }
}

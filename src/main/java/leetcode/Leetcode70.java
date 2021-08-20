package leetcode;

/**
 * @author koujn
 * @date 2021/8/20 17:22
 */
public class Leetcode70 {



    public static void main(String[] args) {

        climbStairs(3);

    }

    public static int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}

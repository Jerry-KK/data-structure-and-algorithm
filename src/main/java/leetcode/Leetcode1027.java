package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2023/4/22 13:17
 */
public class Leetcode1027 {

    public int longestArithSeqLength(int[] nums) {
        int ans = 0;
        int[][] dp = new int[nums.length][1001];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int c = nums[i] - nums[j] + 500;
                dp[i][c] = Math.max(dp[i][c], dp[j][c] + 1);
                ans = Math.max(ans, dp[i][c]);
            }
        }
        return ans + 1;
    }

}

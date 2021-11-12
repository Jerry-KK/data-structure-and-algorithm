package leetcode;

/**
 * @author koujn
 * @date 2021/11/11 9:49
 */
public class Leetcode629 {

    public static void main(String[] args) {
        Leetcode629 body = new Leetcode629();
        int i = body.kInversePairs2(4, 4);
        System.out.println(i);
    }

    public int kInversePairs(int n, int k) {
        int z = 1000000007;
        int[] dp1 = new int[k + 1];
        int[] dp2 = new int[k + 1];
        dp1[0] = 1;
        boolean flag = true;
        for (int i = 2; i <= n; i++) {
            if (flag) {
                for (int j = 0; j < i; j++) {
                    for (int l = 0; l <= k - j; l++) {
                        dp2[l + j] = dp1[l + j] + dp1[l] > 1000000007 ? (dp1[l + j] + dp1[l]) % 1000000007 : (dp1[l + j] + dp1[l]);
                    }
                }
                flag = false;
            } else {
                for (int j = 0; j < i; j++) {
                    for (int l = 0; l <= k - j; l++) {
                        dp1[l + j] = (dp2[l + j] + dp2[l]) % z;
                    }
                }
                flag = true;
            }
        }
        return flag ? dp2[n] : dp1[k];
    }

    public int kInversePairs2(int n, int k) {
        int z = 1000000000 + 7;
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j <= k; j++)
                for (int l = 0; l < i && l + j <= k; l++)
                    dp[i][l + j] = (dp[i][l + j] + dp[i - 1][j]) % z;
        return dp[n][k];
    }
}

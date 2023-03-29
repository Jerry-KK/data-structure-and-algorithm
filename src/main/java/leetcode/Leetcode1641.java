package leetcode;

/**
 * @author lethe
 * @date 2023/3/29 10:18
 */
public class Leetcode1641 {

    public int countVowelStrings(int n) {
        int[] dp = new int[]{1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++)
            for (int j = 4; j >= 1; j--)
                for (int k = 0; k < j; k++)
                    dp[j] += dp[k];
        int ret = 0;
        for (int i = 0; i < 5; i++)
            ret += dp[i];
        return ret;
    }

}

package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/8 13:48
 * 完成13:57
 */
public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        int min = coins[0];
        for (int coin:coins) {
            min = Math.min(coin,min);
        }
        for (int i = 1; i <= amount/min + 1; i++) {
            for (int j = amount; j >= 0 ; --j) {
                if(dp[j] == 1) {
                    for (int coin:coins) {
                        if( coin <= amount && j + coin <= amount) {
                            dp[j + coin] = 1;
                        }
                    }
                }
            }
            if(dp[amount] == 1)
                return i;
        }
        return -1;
    }

}

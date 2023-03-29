package leetcode;

/**
 * @author lethe
 * @date 2023/3/29 11:56
 */
public class Leetcode122 {

    public int maxProfit(int[] prices) {
        int res = 0, l = prices.length,n = prices[0];
        for (int i = 1; i < l; i++) {
            if(prices[i] > n)
                res += prices[i] - n;
            n = prices[i];
        }
        return res;
    }

}

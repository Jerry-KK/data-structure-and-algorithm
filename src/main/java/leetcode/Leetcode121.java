package leetcode;

/**
 * @author lethe
 * @date 2023/3/29 11:48
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int res = 0, l = prices.length, s = prices[0];
        for(int i = 1; i < l; ++i)
            if(prices[i] > s)
                res = Math.max(prices[i] - s, res);
            else
                s = prices[i];
        return res;
    }

}

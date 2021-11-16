package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/11/12 17:08
 */
public class Leetcode375 {

    public static void main(String[] args) {
        Leetcode375 body = new Leetcode375();
        int v = body.getMoneyAmount2(26);
        System.out.println(v);
    }

    public int getMoneyAmount(int n) {
        if(n<=4) {
            return n-1;
        }else {
            return Math.min(2*n-4,n-3+getMoneyAmount(n-4));
        }
    }

    public int getMoneyAmount2(int n) {
        int[] dp = new int[n+1];
        int i = 1;
        for (; i <= 4; i++)
            dp[i] = i-1;
        for (; i <= n; i++) {
            //dp[i] = Math.max(2*i-4 ,i-3 + dp[i-4]);
            int j = i-3;
            int v = 0;
            dp[i] = 2*i -4;
            while (j > 4) {
                v+=j;
                dp[i] = Math.max(dp[i] ,Math.max(v+j+2 ,v + dp[j-5]));
                j-=4;
            }
        }
        return dp[n];
    }

}

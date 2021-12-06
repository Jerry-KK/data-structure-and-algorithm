package chapter41_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/6 11:32
 */

/**
 * 硬币找零问题：
 * 假设我们有多种不同币值的硬币v1,v2,...,vn（单位是元）。如果我们要支付w元，求最少需要多少个硬币。
 * 比如，我们有3种不同的硬币，1元，3元，5元，我们需要支付9元，最少需要3个硬币（3个3元的硬币）
 */
public class AfterClassThinking {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        AfterClassThinking body = new AfterClassThinking();
        int i = body.myTest(nums, 2);
//        int i = body.myTest(nums, 9);
        System.out.println(i);
    }

    public int myTest(int[] nums, int tar) {
        int[] dp = new int[tar+1];
        for (int i = 0; i <= tar; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= tar) {
                dp[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= tar; i++) {
            if(dp[i] != -1)
                continue;
            int r = -1;
            for (int j = 0; j < nums.length; j++) {
                if( i-nums[j] > 0 && dp[i-nums[j]] != -1) {
                    if(r == -1) {
                        r = dp[i-nums[j]];
                    }else {
                        r = Math.min(dp[i-nums[j]],r);
                    }
                }
            }
            if(r != -1)
                dp[i] = r+1;
        }
        return dp[tar];
    }

}

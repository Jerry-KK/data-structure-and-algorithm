package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/8 13:21
 * 13:48做完
 */
public class Leetcode416 {

    public static void main(String[] args) {
        Leetcode416 body = new Leetcode416();
        int[] nums = {1,2,5};
        boolean res = body.canPartition(nums);
        System.out.println(res);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if((sum & 1) == 1) {
            return false;
        }
        int tar = sum>>1;
        boolean[] dp = new boolean[tar+1];
        dp[0] = true;
        for (int num:nums) {
            for (int i = tar - num; i >= 0; --i) {
                if(dp[i]) {
                    dp[i+num] = true;
                }
            }
        }
        return dp[tar];
    }
}

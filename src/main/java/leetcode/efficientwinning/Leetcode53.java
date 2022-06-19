package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/8 13:06
 */
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num:nums) {
            if(sum < 0 && num > sum)
                sum = num;
            else
                sum +=num;
            res = Math.max(res,sum);
        }
        return res;
    }

    //动态规划
    //f(i)表示第i个为止的最大连续字串和，f(i) = Math.max(f(i-1) + nums[i] , nums[i])
    public int maxSubArray2(int[] nums) {
        int pre = 0,maxAns = nums[0];
        for (int num :nums) {
            pre = Math.max(pre+num,num);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }

}

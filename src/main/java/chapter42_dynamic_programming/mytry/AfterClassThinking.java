package chapter42_dynamic_programming.mytry;

/**
 * @author koujn
 * @date 2021/12/6 15:01
 */

/**
 * 我们有一个数字序列包含n个不同的数字，如何求出这个序列中的最长递增子序列长度？
 * 比如2，9，3，6，5，1，7这样一组数字序列，它的最长递增子序列就是2，3，5，7，所以最长递增子序列的长度是4。
 */
public class AfterClassThinking {

    public static void main(String[] args) {
        AfterClassThinking body = new AfterClassThinking();
        int[] nums = {2,9,3,6,5,1,7};
        int i = body.myTry(nums);
        System.out.println(i);
    }

    public int myTry(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max + 1;
    }

}

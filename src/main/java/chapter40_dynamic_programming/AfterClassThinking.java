package chapter40_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/6 10:26
 */

/**
 * “杨辉三角”不知道你听过吗？我们现在对它进行一些改造。每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字这，定义为路径的长度。请你编程求出最高层移动到最底层的最短路径长度。
 *                  5
 *              7       8
 *          2       3       4
 *      4       9       6       1
 *  2       7       9       4       6
 */
public class AfterClassThinking {

    public static void main(String[] args) {
        int[][] nums = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = -1;
            }
        }
        nums[0][0] = 5;
        nums[1][0] = 7;
        nums[1][1] = 8;
        nums[2][0] = 2;
        nums[2][1] = 3;
        nums[2][2] = 4;
        nums[3][0] = 4;
        nums[3][1] = 9;
        nums[3][2] = 6;
        nums[3][3] = 1;
        nums[4][0] = 2;
        nums[4][1] = 7;
        nums[4][2] = 9;
        nums[4][3] = 4;
        nums[4][4] = 6;
        AfterClassThinking body = new AfterClassThinking();
        int i = body.myTest(nums);
        System.out.println(i);
    }

    public int myTest(int[][] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = nums[0][0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; --j) {
                dp[j] = Math.min(dp[j-1],dp[j]) + nums[i][j];
            }
            dp[0] += nums[i][0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,dp[i]);
        }
        return min;
    }
}

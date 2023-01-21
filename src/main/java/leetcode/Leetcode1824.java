package leetcode;

/**
 * @author lethe
 * @date 2023/1/21 11:53
 */
public class Leetcode1824 {

    public static void main(String[] args) {
        Leetcode1824 body = new Leetcode1824();
//        int[] obstacles = {0,1,2,3,0};
        int[] obstacles = {0,0,3,1,0,1,0,2,3,1,0};
        System.out.println(body.minSideJumps(obstacles));
    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = {0, 1, 0, 1};
        for (int i = 1; i < n; i++) {
            int o = obstacles[i];
            int b = obstacles[i-1];
            dp[o] = n;
            if(o == 0) {
                if(b == 1)
                    dp[1] = Math.min(dp[2],dp[3]) + 1;
                if(b == 2)
                    dp[2] = Math.min(dp[1],dp[3]) + 1;
                if(b == 3)
                    dp[3] = Math.min(dp[1],dp[2]) + 1;
            }
            if(o == 1) {
                if(b == 3)
                    dp[3] = dp[2] + 1;
                if(b == 2)
                    dp[2] = dp[3] + 1;
            }
            if(o == 2) {
                if(b == 1)
                    dp[1] = dp[3] + 1;
                if(b == 3)
                    dp[3] = dp[1] + 1;
            }
            if(o == 3) {
                if(b == 1)
                    dp[1] = dp[2] + 1;
                if(b == 2)
                    dp[2] = dp[1] + 1;
            }
        }
        return Math.min(Math.min(dp[1], dp[2]), dp[3]);
    }


}

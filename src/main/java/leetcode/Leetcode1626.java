package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2023/3/22 15:12
 */
public class Leetcode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res;
        int[] dp = new int[n];
        res = dp[0] = arr[0][0];
        for (int i = 1; i < n; ++i) {
            if(arr[i][0] == arr[i-1][0] && arr[i][1] == arr[i-1][1]) {
                dp[i] = dp[i-1];
            }else {
                for (int j = i-1; j >= 0 ; --j)
                    if(arr[j][1] <= arr[i][1])
                        dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += arr[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}

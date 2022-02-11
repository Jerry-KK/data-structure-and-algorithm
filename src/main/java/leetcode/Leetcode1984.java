package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2022/2/11 12:47
 */
public class Leetcode1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++)
            res = Math.min(nums[i+k-1]-nums[i],res);
        return res;
    }

}

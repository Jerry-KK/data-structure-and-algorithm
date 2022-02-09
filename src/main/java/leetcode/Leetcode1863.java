package leetcode;

import java.util.LinkedList;

/**
 * @author lethe
 * @date 2022/2/9 23:43
 */
public class Leetcode1863 {

    public static void main(String[] args) {

    }

    public int subsetXORSum(int[] nums) {
        int[] sum = {0};
        helper(nums,0,0,sum);
        return sum[0];
    }

    private void helper(int[] nums, int l, int v, int[] sum) {
        if(l == nums.length) {
            sum[0] += v;
        }else {
            helper(nums,l+1,v,sum);
            helper(nums,l+1,v^nums[l],sum);
        }
    }

}

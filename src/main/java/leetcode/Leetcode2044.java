package leetcode;

/**
 * @author lethe
 * @date 2022/3/15 0:21
 */
public class Leetcode2044 {

    public static void main(String[] args) {
        System.out.println(1|3);
    }

    int ans = 0;
    int max = 0;

    public int countMaxOrSubsets(int[] nums) {
        max = 0;
        for (int num:nums) {
            max |= num;
        }
        ans = 0;
        helper(nums,0,0);
        return ans;
    }

    private void helper(int[] nums,int idx,int h) {
        if(idx == nums.length) {
            if(h == max)
                ++ans;
        }else if(idx < nums.length) {
            helper(nums,idx+1,h);
            helper(nums,idx+1,h|nums[idx]);
        }
    }



}

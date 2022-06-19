package leetcode;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author lethe
 * @date 2022/3/4 0:40
 */
public class Leetcode2104 {

    public static void main(String[] args) {
        Leetcode2104 body = new Leetcode2104();
        int[] nums = {4,-2,-3,4,1};
        long ans = body.subArrayRanges(nums);
        System.out.println(ans);
    }

    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int max = nums[i],min = nums[i];
            for (int j = i+1; j < l; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

}

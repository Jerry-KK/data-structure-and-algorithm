package leetcode.efficientwinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lethe
 * @date 2022/3/7 18:57
 */
public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if(a > 0 && nums[a] == nums[a-1]) {
                continue;
            }
            for (int b = a+1; b < nums.length; b++) {
                if(b > a+1 && nums[b] == nums[b-1]) {
                    continue;
                }
                int tar = target-nums[a]-nums[b];
                int d = nums.length-1;
                for (int c = b+1; c < nums.length; c++) {
                    if(c > b+1 && nums[c] == nums[c-1]) {
                        continue;
                    }
                    while (c < d && nums[c] + nums[d] > tar) {
                        --d;
                    }
                    if(c == d) {
                        continue;
                    }
                    if(nums[c] + nums[d] == tar) {
                        ArrayList<Integer> ans = new ArrayList<>(4);
                        ans.add(nums[a]);
                        ans.add(nums[b]);
                        ans.add(nums[c]);
                        ans.add(nums[d]);
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }

}

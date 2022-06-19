package leetcode.efficientwinning;

import java.util.HashMap;

/**
 * @author lethe
 * @date 2022/3/5 13:45
 */
public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            Integer val = map.get(key);
            if(val != null) {
                ans[0] = val;
                ans[1] = i;
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}

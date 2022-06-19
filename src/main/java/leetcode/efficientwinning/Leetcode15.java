package leetcode.efficientwinning;

import java.util.*;

/**
 * @author lethe
 * @date 2022/3/7 17:42
 */
public class Leetcode15 {
    public static void main(String[] args) {
        Leetcode15 body = new Leetcode15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = body.threeSum2(nums);
        System.out.println(1);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],new LinkedList<>());
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1 ; j++) {
                int tar = 0 -nums[i] - nums[j];
                List<Integer> idxList = map.get(tar);
                if(idxList != null) {
                    for (int idx:idxList) {
                        if(idx > j) {
                            List<Integer> ans = new ArrayList<>(3);
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[idx]);
                            result.add(ans);
                            break;
                        }
                    }
                }
                while (j+1 < nums.length && nums[j+1] == nums[j]) {
                    ++j;
                }
            }
            while (i+1 < nums.length && nums[i+1] == nums[i]) {
                ++i;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int tar = -nums[i];
            int end = nums.length - 1;
            for (int start = i + 1; start < nums.length-1; start++) {
                if (start > i+1 && nums[start] == nums[start-1]) {
                    continue;
                }
                while (start < end && nums[start] + nums[end] > tar) {
                    --end;
                }
                if(start == end) {
                    continue;
                }
                if(nums[start] + nums[end] == tar) {
                    ArrayList<Integer> ans = new ArrayList<>(3);
                    ans.add(nums[i]);
                    ans.add(nums[start]);
                    ans.add(nums[end]);
                    res.add(ans);
                }
            }
        }
        return res;
    }

}

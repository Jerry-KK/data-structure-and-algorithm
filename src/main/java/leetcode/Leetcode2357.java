package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2023/2/24 20:56
 */
public class Leetcode2357 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int i = 0, r = 0;
        for (int num : nums) {
            if (num > i) {
                ++r;
                i = num;
            }
        }
        return r;
    }

    public int minimumOperations2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        set.remove(0);
        return set.size();
    }

}

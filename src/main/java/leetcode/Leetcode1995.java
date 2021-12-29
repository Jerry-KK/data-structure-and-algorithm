package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @author lethe
 * @date 2021/12/29 23:21
 */
public class Leetcode1995 {

    public static void main(String[] args) {
        Leetcode1995 body = new Leetcode1995();
        int[] nums = {1,1,1,3,5};
        int res = body.countQuadruplets(nums);
        System.out.println(res);
    }

    public int countQuadruplets(int[] nums) {
        int sum = 0;
        for (int a = 0; a < nums.length-3; a++) {
            for (int b = a+1; b < nums.length-2; b++) {
                for (int c = b+1; c < nums.length-1; c++) {
                    for (int d = c+1; d < nums.length ; d++) {
                        if(nums[a] + nums[b] + nums[c] == nums[d]){
                            ++sum;
                        }
                    }
                }
            }
        }
        return sum;
    }

}

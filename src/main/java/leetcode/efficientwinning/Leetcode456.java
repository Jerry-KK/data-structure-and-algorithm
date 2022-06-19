package leetcode.efficientwinning;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lethe
 * @date 2022/3/9 19:17
 */
public class Leetcode456 {
    public static void main(String[] args) {
        Leetcode456 body = new Leetcode456();
        int[] nums = {-1,3,2,0};
        boolean res = body.find132pattern(nums);
        System.out.println(res);
    }

    public boolean find132pattern(int[] nums) {
        int l = nums.length;
        int med = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = l-1; i >= 0 ; --i) {
            if(nums[i] < med) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                med = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

}

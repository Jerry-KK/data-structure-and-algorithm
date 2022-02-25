package leetcode;

import java.util.Stack;

/**
 * @author lethe
 * @date 2022/1/12 18:37
 */
public class Leetcode334 {
    public static void main(String[] args) {
        Leetcode334 body = new Leetcode334();
        int[] nums = {5,1,6};
        boolean res = body.increasingTriplet(nums);
        System.out.println(res);
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        int[] arr = new int[3];
        arr[0] = nums[0];
        for (int i = 1,idx = 0; i < nums.length; i++) {
            if(idx == 0) {
                if(nums[i]<= arr[0]) {
                    arr[0] = nums[i];
                }else {
                    arr[++idx] = nums[i];
                }
            }else if(idx == 1) {
                if (arr[1] < nums[i]) {
                    return true;
                }else {
                    if(nums[i] > arr[0]) {
                        arr[1] = nums[i];
                    }else {
                        arr[++idx] = nums[i];
                    }
                }
            }else {
                if (arr[1] < nums[i]) {
                    return true;
                }else if(arr[2] < nums[i]) {
                    arr[0] = arr[2];
                    arr[1] = nums[i];
                    --idx;
                }else if(arr[0] < nums[i]) {
                    arr[1] = nums[i];
                    --idx;
                }else {
                    arr[2] = nums[i];
                }
            }
        }
        return false;
    }
}

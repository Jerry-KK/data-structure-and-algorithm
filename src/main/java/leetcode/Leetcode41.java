package leetcode;

/**
 * @author koujn
 * @date 2021/11/30 10:19
 */
public class Leetcode41 {
    public static void main(String[] args) {
        Leetcode41 body = new Leetcode41();
//        int[] nums = {3,4,-1,1};
        int[] nums = {1};
        int i = body.firstMissingPositive2(nums);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if(num > 0 && num <= nums.length )
                arr[num-1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                return i+1;
        }
        return nums.length+1;
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if(nums[i] <= 0)
                nums[i] = nums.length+1;
        for (int num:nums) {
            int abs = Math.abs(num);
            if (abs <= nums.length && nums[abs - 1] > 0)
                nums[abs - 1] = -nums[abs - 1];
        }
        for (int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                return i+1;
        return nums.length+1;
    }
}

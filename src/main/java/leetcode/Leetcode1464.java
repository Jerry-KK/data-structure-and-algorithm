package leetcode;

/**
 * @author koujn
 * @date 2021/11/24 16:01
 */
public class Leetcode1464 {

    public int maxProduct(int[] nums) {
        int[] res = new int[]{nums[0],nums[1]};
        int min = res[0] < res[1] ? 0 : 1;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] > res[min]) {
                res[min] = nums[i];
                min = res[0] < res[1] ? 0 : 1;
            }
        }
        return (res[0]-1) * (res[1]-1);
    }

}

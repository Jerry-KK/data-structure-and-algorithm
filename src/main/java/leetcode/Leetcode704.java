package leetcode;

/**
 * @author koujn
 * @date 2021/9/6 9:18
 */
public class Leetcode704 {

    public int search(int[] nums, int target) {
        int s =  0;
        int e = nums.length-1;
        while (s <= e) {
            int p = (s+e)/2;
            if(nums[p] == target) {
                return p;
            }else if(nums[p] < target) {
                s = p-1;
            }else {
                e = p+1;
            }
        }
        return -1;
    }

}

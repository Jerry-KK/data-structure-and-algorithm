package leetcode;

/**
 * @author lethe
 * @date 2022/2/14 16:59
 */
public class Leetcode540 {

    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num:nums)
            res ^= num;
        return res;
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (right - left) >> 1 + left;
            if((mid & 1) == 0) {
                if(mid + 1 < nums.length && nums[mid] == nums[mid+1]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }else {
                if(mid - 1 >= 0 && nums[mid] == nums[mid-1]) {
                    left = mid + 2;
                }else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }

}

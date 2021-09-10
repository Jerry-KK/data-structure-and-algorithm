package leetcode;

/**
 * @author koujn
 * @date 2021/9/10 17:00
 */
public class Leetcode31 {
    public static void main(String[] args) {
        Leetcode31 body = new Leetcode31();
        int[] nums = {1,3};
        int search = body.search(nums, 3);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int v = nums[0];
        int low = 1;
        int high = n - 1;
        int m = n-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(nums[mid] < v){
                if(mid == 0 || nums[mid - 1] >= v) {
                    m = mid-1;
                    break;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(target < v) {
            low = m+1;
            high = n - 1;
        }else {
            low = 0;
            high = m;
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(nums[mid] > target) {
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

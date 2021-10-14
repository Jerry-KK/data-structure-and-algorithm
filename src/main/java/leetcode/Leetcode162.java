package leetcode;

/**
 * @author koujn
 * @date 2021/9/15 9:03
 */
public class Leetcode162 {

    public static void main(String[] args) {
        Leetcode162 body = new Leetcode162();
        int[] nums = {1,2,3,7,6};
        int peakElement = body.findPeakElement(nums);
        System.out.println(peakElement);

    }

    //是否找到标记位
    private boolean flag = false;

    private int res = -1;

    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        if(nums[low] > nums[low+1])
            return low;
        if(nums[high] > nums[high-1])
            return high;
        test2(nums,low,high);
        return res;
    }

    public void test2(int[] nums, int low, int high) {
        /**
         * mid 点通过4种情况判断；
         * 1.mid点对于左右来说是最低点，取右边(取左边也可以，这里说明左右都有峰值)
         * 2.mid点自左向右递增，取右边
         * 3.mid点自左向右递减，取左边
         * 4.mid点对于左右来说是最高点，返回
         */

        if(flag)
            return;
        if(low >= high){
            if(nums[low] > nums[low+1]){
                flag = true;
                res = low;
            }
            return;
        }
        int mid = low + (( high - low ) >> 1 );
        if(nums[mid] < nums[mid+1]) {
            test2(nums,mid+1,high);
        } else if (nums[mid] > nums[mid + 1]){
            if(nums[mid] > nums[mid - 1]) {
                flag = true;
                res = mid;
                return;
            }else {
                test2(nums,low,mid-1);
            }
        }
    }
}

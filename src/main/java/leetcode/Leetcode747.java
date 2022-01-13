package leetcode;

/**
 * @author lethe
 * @date 2022/1/13 0:26
 */
public class Leetcode747 {
    public static void main(String[] args) {
        Leetcode747 body = new Leetcode747();
        int[] nums = {0,0,0,1};
        int res = body.dominantIndex(nums);
        System.out.println(res);
    }

    public int dominantIndex(int[] nums) {
        if(nums.length == 1)
            return 0;
        int a,b;
        if(nums[0] > nums[1]) {
            a = 0;
            b = 1;
        }else {
            a = 1;
            b = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] > nums[b]) {
                if(nums[i] > nums[a]) {
                    b = a;
                    a = i;
                }else {
                    b = i;
                }
            }
        }
        return nums[a] >= 2 * nums[b] ? a : -1;
    }

}

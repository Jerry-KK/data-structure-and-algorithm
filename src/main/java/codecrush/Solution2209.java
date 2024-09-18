package codecrush;

public class Solution2209 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{3,2,1,0,4}));
    }


    public static boolean jump(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        arr[0] = 1;
        for (int i = 0; i < l; i++) {
            if (arr[i] == 0)
                return false;
            for (int j = 1; j <= nums[i] && i+j < l; j++) {
                arr[i+j] = 1;
            }
        }
        return true;
    }
}

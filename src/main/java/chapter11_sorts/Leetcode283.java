package chapter11_sorts;

/**
 * @author koujn
 * @date 2021/7/28 14:32
 */
public class Leetcode283 {

    public static void main(String[] args) {
       // int[] arr = {0,2,0,4,6,0,0,3,0};
        int[] arr = new int[1000000];
        int[] brr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            if(i == 0) {
                arr[i] = 1;
                brr[i] = 1;
            }else {
                arr[i] = 0;
                brr[i] = 0;
            }
        }
        long s1 = System.currentTimeMillis();
        moveZeroes4(arr);
        long e1 = System.currentTimeMillis();
        long s2 = System.currentTimeMillis();
        moveZeroes2(arr);
        long e2 = System.currentTimeMillis();
        System.out.println((e1-s1));
        System.out.println((e2-s2));
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length < 1) {
            return;
        }
        int i = nums.length - 1,j = i;
        for (; j >= 0 ; j--) {
            if(nums[j] == 0) {
                for (int k = j; k < i; k++) {
                    nums[k] = nums[k+1];
                }
                nums[i--] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if(nums.length < 1) {
            return;
        }
        int i = 0,j = 0;
        for (; j < nums.length ; j++) {
            if(nums[j] != 0 ) {
                if(i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
    public static void moveZeroes3(int[] nums) {
        int i = 0,j = 0;
        for (; j < nums.length ; j++) {
            if(nums[j] != 0 ) {
                nums[i++] = nums[j];
            }
        }
        while (i<nums.length) {
            nums[i++] = 0;
        }
    }

    public static void moveZeroes4(int[] nums) {
        int length = nums.length;
        int curr = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[curr++] = num;
            }
        }
        for (int i = curr; i < length; i++) {
            nums[i] = 0;
        }
    }
}

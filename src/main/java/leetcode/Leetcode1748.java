package leetcode;

import java.util.HashMap;

/**
 * @author lethe
 * @date 2022/2/6 10:59
 */
public class Leetcode1748 {

    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] arr =new int[101];
        for (int num:nums)
            ++arr[num];
        for (int i = 1; i <= 100 ; i++)
            if(arr[i] == 1)
                sum+=i;
        return sum;
    }

    public int sumOfUnique2(int[] nums) {
        int sum = 0;
        int[] arr =new int[101];
        for (int num:nums) {
            if(arr[num] == 0) {
                sum+=num;
                arr[num] = 1;
            }else if(arr[num] == 1) {
                sum-=num;
                arr[num] = 2;
            }
        }
        return sum;
    }

}

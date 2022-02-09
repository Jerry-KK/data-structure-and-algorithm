package leetcode;

import java.util.HashMap;

/**
 * @author lethe
 * @date 2022/2/9 1:09
 */
public class Leetcode2006 {

    public int countKDifference(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; ++i) {
            sum += map.getOrDefault(nums[i]+k,0) + map.getOrDefault(nums[i]-k,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return sum;
    }

    public int countKDifference2(int[] nums, int k) {
        int sum = 0;
        int[] arr = new int[101];
        for (int i = 0; i < nums.length ; ++i) {
            int v = nums[i];
            if((v + k) <= 100) sum += arr[v+k];
            if(v > k) sum += arr[v-k];
            ++arr[v];
        }
        return sum;
    }

    public int countKDifference3(int[] nums, int k) {
        int sum = 0;
        int[] arr = new int[101];
        for (int num:nums)
            ++arr[num];
        for (int i = 1; i <= 100-k ; ++i)
            sum += arr[i] * arr[i+k];
        return sum;
    }

}

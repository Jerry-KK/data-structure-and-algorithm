package chapter38_divide_and_conquer;

import java.util.List;

/**
 * @author lethe
 * @date 2021/8/15 20:02
 */

public class Leetcode315 {

    public static int[] index = null;
    public static int[] temp = null;
    public static int[] tempIndex = null;
    public static int[] ans = null;


    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        myCountSmaller(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        return null;
    }

    public static int[] myCountSmaller(int[] nums) {
        index = new int[nums.length];
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums,0,nums.length-1);
        return ans;
    }

    private static void mergeSort(int[] nums, int p, int r) {
        if(p >= r) return;
        int q = (p+r)/2;
        mergeSort(nums,p,q);
        mergeSort(nums,q+1,r);
        merge(nums,p,q,r);
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int i = p, j=q+1, k = p;
        while (i<=q && j <= r) {
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                tempIndex[k] = index[i];
                ans[index[i]] += (j - q  - 1);
                ++i;
                ++k;
            } else {
                temp[k] = nums[j];
                tempIndex[k] = index[j];
                ++j;
                ++k;
            }
        }
        while (i <= q) {
            temp[k] = nums[i];
            tempIndex[k] = index[i];
            ans[index[i]] += j - q  - 1;
            ++i;
            ++k;
        }
        while (j <= r) {
            temp[k] = nums[j];
            tempIndex[k] = index[j];
            ++j;
            ++k;
        }
        for (int l = p; l <= r; l++) {
            index[l] = tempIndex[l];
            nums[l] = temp[l];
        }
    }
}

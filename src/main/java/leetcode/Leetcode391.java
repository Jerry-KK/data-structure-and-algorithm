package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author koujn
 * @date 2021/11/16 9:31
 */
public class Leetcode391 {

    public boolean isRectangleCover(int[][] rectangles) {
        int[] a = new int[4];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int[] arr: rectangles) {
            int left = arr[0] * arr[0] + arr[1]* arr[1];
            if(left < min) {
                min = left;
                a[0] = arr[0];
                a[1] = arr[1];
            }
            int right = arr[2] * arr[2] + arr[3]* arr[3];
            if(right > max) {
                max = right;
                a[2] = arr[2];
                a[3] = arr[3];
            }
            sum += (arr[2] - arr[0]) * (arr[3] - arr[1]);
        }
        return (a[2] - a[0]) * (a[3] - a[1]) == sum;
    }

   /* public boolean isRectangleCover2(int[][] rectangles) {
        int[] a = new int[4];
        Set<int[]> set = new HashSet<>();
        for (int[] arr:rectangles) {

        }


    }*/



}

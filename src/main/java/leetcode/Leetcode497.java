package leetcode;

import java.util.Random;

/**
 * @author lethe
 * @date 2022/6/9 22:14
 */
public class Leetcode497 {

    class Solution {

        int[] arr;
        int[][] re;
        Random r;

        public Solution(int[][] rects) {
            int l = rects.length;
            re = rects;
            arr = new int[l];
            for (int i = 0, add = 0; i < l; i++) {
                arr[i] = (re[i][2]-re[i][0]+1) * (re[i][3]-re[i][1]+1) + add;    //这里+1因为线也算，所以实际面积是包含点的个数
                add = arr[i];
            }
            r = new Random();
        }

        public int[] pick() {
            int m = arr[arr.length-1];
            int tar = r.nextInt(m) + 1;
            int i = binarySearch(tar, arr);
            int[] res = new int[2];
            res[0] = r.nextInt(re[i][2]-re[i][0] + 1) + re[i][0];
            res[1] = r.nextInt(re[i][3]-re[i][1] + 1) + re[i][1];
            return res;
        }

        private int binarySearch(int tar,int[] arr) {
            int s = 0,e = arr.length - 1;
            while (s <= e) {
                int mid = s + ((e-s)>>>1);
                if(arr[mid] > tar) {
                    e = mid - 1;
                } else if(arr[mid] < tar) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            }
            return s;
        }

    }

}

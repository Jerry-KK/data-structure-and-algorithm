package leetcode;

import java.util.Arrays;

/**
 * @author koujn
 * @date 2021/12/20 15:35
 */
public class Leetcode475 {
    public static void main(String[] args) {
        Leetcode475 body = new Leetcode475();
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        int radius = body.findRadius(houses, heaters);
        System.out.println(radius);
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int h:houses) {
            res = Math.max(res,binarySearch(h,heaters));
        }
        return res;
    }

    private int binarySearch(int tar, int[] heaters) {
        int low = 0;
        int high = heaters.length-1;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if(heaters[mid] < tar) {
                low = mid + 1;
            }else if(heaters[mid] > tar) {
                high = mid - 1;
            } else {
                return 0;
            }
        }
        if(low == heaters.length)
            return tar - heaters[high];
        if(high == -1)
            return heaters[low] - tar;
        return Math.min(tar - heaters[high],heaters[low] - tar);
    }

}

package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author koujn
 * @date 2021/12/3 10:34
 */
public class Leetcode1005 {

    public static void main(String[] args) {
        Leetcode1005 main = new Leetcode1005();
        int[] nums = {4,2,3};
        int i = main.largestSumAfterKNegations(nums, 1);
        System.out.println(i);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for (int num:nums) {
            minHeap.offer(num);
            sum += num;
        }
        for (int i = 0; i < k; i++) {
            Integer poll = minHeap.poll();
            minHeap.offer(-poll);
            sum-= 2* poll;
        }
        return sum;
    }

}

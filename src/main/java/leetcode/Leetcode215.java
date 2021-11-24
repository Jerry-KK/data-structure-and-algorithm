package leetcode;

import java.util.PriorityQueue;

/**
 * @author koujn
 * @date 2021/11/24 15:51
 */
public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num:nums) {
            if(minHeap.size()>=k && minHeap.peek() >= num)
                continue;
            if(minHeap.size() >= k)
                minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }

}

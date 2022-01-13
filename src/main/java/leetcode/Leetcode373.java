package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author lethe
 * @date 2022/1/14 0:18
 */
public class Leetcode373 {

    public static void main(String[] args) {
        Leetcode373 body = new Leetcode373();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 10;
        List<List<Integer>> res = body.kSmallestPairs2(nums1, nums2, k);
        res.forEach(e->{
            System.out.println("[" + e.get(0) + " , " + e.get(1) + "]");
        });
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        List<List<Integer>> res = new ArrayList<>(k);
        List<Integer> list;
        for (int i = 0; i < nums1.length; i++) {
            int[] arr = new int[3];
            arr[0] = i;
            //arr[1] = 0;
            arr[2] = nums1[i] + nums2[0];
            minHeap.add(arr);
        }
        while (!minHeap.isEmpty()) {
            int[] minArr = minHeap.poll();
            list = new ArrayList<>(2);
            list.add(nums1[minArr[0]]);
            list.add(nums2[minArr[1]]);
            res.add(list);
            if(res.size() == k)
                return res;
            if(minArr[1] + 1 < nums2.length) {
                minArr[1] += 1;
                minArr[2] = nums1[minArr[0]] + nums2[minArr[1]];
                minHeap.add(minArr);
            }
        }
        return res;
    }


    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->
                nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        List<List<Integer>> res = new ArrayList<>(k);
        List<Integer> list;
        for (int i = 0; i < nums1.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            minHeap.add(arr);
        }
        while (!minHeap.isEmpty()) {
            int[] minArr = minHeap.poll();
            list = new ArrayList<>(2);
            list.add(nums1[minArr[0]]);
            list.add(nums2[minArr[1]]);
            res.add(list);
            if(res.size() == k)
                return res;
            if(minArr[1] + 1 < nums2.length) {
                minArr[1] += 1;
                minHeap.add(minArr);
            }
        }
        return res;
    }
}

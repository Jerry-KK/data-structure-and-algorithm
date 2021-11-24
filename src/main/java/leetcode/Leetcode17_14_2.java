package leetcode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author koujn
 * @date 2021/11/24 15:00
 */
public class Leetcode17_14_2 {

    public static void main(String[] args) {
        Leetcode17_14_2 body = new Leetcode17_14_2();
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] ints = body.smallestK2(arr, 4);
        IntStream.of(ints).forEach(System.out::println);
    }

    public int[] smallestK(int[] arr, int k) {
        if(k == 0)
            return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p1,p2)->p2-p1);
        for (int j : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(j);
            } else if (j < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(j);
            }
        }
        return maxHeap.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] smallestK2(int[] arr, int k) {
        if(k == 0)
            return new int[0];
        int[] heap = new int[k+1];
        for (int i = 0; i < k; i++) {
            heap[i+1] = arr[i];
        }
        for (int i = k / 2; i >= 1; --i) {
            heapify(heap,i);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < heap[1]) {
                heap[1] = arr[i];
                heapify(heap,1);
            }
        }
        int[] res = new int[heap.length-1];
        for (int i = 0; i < res.length; i++)
            res[i] = heap[i+1];
        return res;
    }

    private void swap(int[] arr, int i , int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private void heapify(int[] heap, int i) {
        while (true) {
            int maxPoint = i;
            if(i * 2 < heap.length && heap[i] < heap[i*2])
                maxPoint = i*2;
            if(i * 2 + 1 < heap.length && heap[maxPoint] < heap[i*2 +1])
                maxPoint = i*2 +1;
            if(maxPoint == i)
                break;
            swap(heap,i,maxPoint);
            i = maxPoint;
        }
    }



}

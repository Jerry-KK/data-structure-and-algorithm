package leetcode;

import java.util.PriorityQueue;

/**
 * @author lethe
 * @date 2023/5/21 12:42
 */
public class LCP33 {

    public static void main(String[] args) {
        /*int[] bucket = {1,3};
        int[] vat = {6,8};*/
        int[] bucket = {0,0,0,0,0,0,0,0,0,0};
        int[] vat = {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
        LCP33 body = new LCP33();
        System.out.println(body.storeWater2(bucket, vat));
    }

    public int storeWater(int[] bucket, int[] vat) {
        int l = bucket.length, n = 0;
        int[] tmp = new int[l];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> tmp[b] - tmp[a]);
        for (int i = 0; i < l; i++) {
            if(vat[i] != 0) {
                if(bucket[i] == 0) {
                    ++n;
                    ++bucket[i];
                    tmp[i] = vat[i];
                } else {
                    tmp[i] = (vat[i]+bucket[i]-1)/bucket[i];
                }
            }
            maxHeap.add(i);
        }
        int res = n + tmp[maxHeap.peek()];
        while (n < res) {
            Integer i = maxHeap.poll();
            ++n;
            ++bucket[i];
            tmp[i] = (vat[i]+bucket[i]-1)/bucket[i];
            maxHeap.add(i);
            res = Math.min(res, n + tmp[maxHeap.peek()]);
        }
        return res;
    }

    /**
     * 1 <= bucket.length == vat.length <= 100
     * 0 <= bucket[i], vat[i] <= 10^4
     * 所以最大次数为1000100，之前用Integer.MAX_VALUE会越界
     */
    public int storeWater2(int[] bucket, int[] vat) {
        int l = bucket.length, n = 0;
        int[] tmp = new int[l];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> tmp[b] - tmp[a]);
        for (int i = 0; i < l; i++) {
            if(vat[i] != 0)
                tmp[i] = bucket[i] == 0 ? 1000100 : (vat[i]+bucket[i]-1)/bucket[i];
            maxHeap.add(i);
        }
        int res = tmp[maxHeap.peek()];
        while (n < res) {
            Integer i = maxHeap.poll();
            ++n;
            ++bucket[i];
            tmp[i] = (vat[i]+bucket[i]-1)/bucket[i];
            maxHeap.add(i);
            res = Math.min(res, n + tmp[maxHeap.peek()]);
        }
        return res;
    }

}

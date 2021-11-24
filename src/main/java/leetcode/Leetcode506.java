package leetcode;

import java.util.PriorityQueue;

/**
 * @author koujn
 * @date 2021/11/24 16:24
 */
public class Leetcode506 {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};
        Leetcode506 body = new Leetcode506();
        body.findRelativeRanks(score);
        System.out.println(1);


    }

    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->score[a]-score[b]);
        for (int i = 0; i < score.length; i++) {
            minHeap.offer(i);
        }

        for (int i = 0; i < score.length-3 ; i++)
            res[minHeap.poll()] = String.valueOf(score.length-i);
        if(score.length >= 3)
            res[minHeap.poll()] = "Bronze Medal";
        if(score.length >= 2)
            res[minHeap.poll()] = "Silver Medal";
        res[minHeap.poll()] = "Gold Medal";
        return res;
    }

}

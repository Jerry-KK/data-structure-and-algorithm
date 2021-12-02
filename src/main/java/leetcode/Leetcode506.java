package leetcode;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author koujn
 * @date 2021/11/24 16:24
 */
public class Leetcode506 {
    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        Leetcode506 body = new Leetcode506();
        body.findRelativeRanks2(score);
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

    public String[] findRelativeRanks2(int[] score) {
        Integer[] arr = new Integer[score.length];
        String[] srr = {"Gold Medal","Silver Medal","Bronze Medal"};
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++)
            arr[i] = i;
        Arrays.sort(arr,(a,b)->score[b]-score[a]);
        int i = 0;
        for (int a:arr) {
            if(i < 3) {
                res[a] = srr[i];
            }else {
                res[a] = String.valueOf(1+i);
            }
            ++i;
        }
        return res;
    }

    public String[] findRelativeRanks3(int[] score) {
        final Integer[] i = {0};
        int[] idx = {1};
        String[] res = new String[score.length];
        Stream.generate(() -> i[0]++)
                .limit(score.length)
                .sorted((a, b) -> score[b] - score[a])
                .forEach(e->{
                    switch (idx[0]) {
                        case 1:
                            res[e] = "Gold Medal";
                            break;
                        case 2:
                            res[e] = "Silver Medal";
                            break;
                        case 3:
                            res[e] = "Bronze Medal";
                            break;
                        default:
                            res[e] = String.valueOf(idx[0]);
                    }
                    ++idx[0];
                });
        return res;
    }

}

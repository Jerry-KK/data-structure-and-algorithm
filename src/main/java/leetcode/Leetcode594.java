package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2021/11/20 12:11
 */
public class Leetcode594 {

    public static void main(String[] args) {
        Leetcode594 body = new Leetcode594();
        int[] nums = {1, 1, 1, 1};
//        int[] nums = {1,3,2,2,5,2,3,7};
//        int[] nums = {1};
        int lhs = body.findLHS(nums);
        System.out.println(lhs);
    }

    public int findLHS(int[] nums) {
        if(nums.length < 2 )
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] max = {0};
        for (int n:nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        map.forEach((k,v)->{
            int kSize = Math.max(map.getOrDefault(k+1,0),map.getOrDefault(k-1,0));
            if(kSize > 0) {
                max[0] = Math.max(max[0],kSize+map.get(k));
            }
        });
        return max[0];
    }

    public int findLHS2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int n:nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int key: map.keySet()) {
            if(map.containsKey(key+1))
                max = Math.max(max,map.get(key) + map.get(key+1));
        }
        return max;
    }


}

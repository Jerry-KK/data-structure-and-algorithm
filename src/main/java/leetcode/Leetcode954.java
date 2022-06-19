package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lethe
 * @date 2022/4/1 15:43
 */
public class Leetcode954 {

    public static void main(String[] args) {
        int[] arr = {2,1,2,1,1,1,2,2};
        Leetcode954 body = new Leetcode954();
        boolean res = body.canReorderDoubled(arr);
        System.out.println(res);
    }

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a:arr) {
            if(a % 2 != 1) {
                int tar = a > 0 ? a/2 : a*2;
                if(map.containsKey(tar)) {
                    if(map.get(tar) == 1) {
                        map.remove(tar);
                    }else {
                        map.put(tar,map.get(tar)-1);
                    }
                    continue;
                }
            }
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return map.isEmpty();
    }

}

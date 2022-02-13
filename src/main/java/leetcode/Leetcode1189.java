package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2022/2/13 14:08
 */
public class Leetcode1189 {

    public int maxNumberOfBalloons(String text) {
        String s = "balloon";
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int[] res = {Integer.MAX_VALUE};
        for (char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        for (char c : text.toCharArray())
            map2.put(c,map2.getOrDefault(c,0)+1);
        map.forEach((k,v)-> res[0] = Math.min(map2.getOrDefault(k,0)/v,res[0]));
        return res[0];
    }

}

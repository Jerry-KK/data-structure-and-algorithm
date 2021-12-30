package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/12/30 6:12
 */
public class Leetcode846 {

    public static void main(String[] args) {
        Leetcode846 body = new Leetcode846();
        int[] hand = {53,78,62,108,83,56,66,110,49,104,117,123,86,131,94,107,84,103,42,127,100,50,55,97,81,93,71,45,63,
                39,91,87,129,126,84,125,73,95,116,47,106,52,121,54,38,68,69,76,89,90,57,67,86,114,64,87,79,92,115,60,51,
                105,132,101,59,130,44,85,80,82,48,65,128,102,74,61,40,46,98,111,109,119,72,43,112,120,58,113,77,88,41,
                118,75,85,124,122,96,83,99,70};
        boolean res = body.isNStraightHand(hand, 50);
        System.out.println(res);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:hand) {
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        int[] arr = map.keySet().stream().mapToInt(Integer::valueOf).sorted().toArray();
        for (int key:arr) {
            int s = map.getOrDefault(key,0);
            if(s > 0) {
                for (int i = key; i < key + groupSize; i++) {
                    if (map.getOrDefault(i,0) < s )
                        return false;
                    map.put(i, map.get(i) - s);
                }
            }
        }
        return true;
    }

}

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author lethe
 * @date 2022/2/8 0:18
 */
public class Leetcode1001 {

    public static void main(String[] args) {
        Leetcode1001 body = new Leetcode1001();

        int n = 5;
        int[][] lamps = {{0,0},{0,1},{0,4}};
        int[][] queries = {{0,4},{0,1},{0,2}};
        int[] res = body.gridIllumination(n, lamps, queries);
        for (int r:res) {
            System.out.print(r + " , ");
        }
        System.out.println();

    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int[] res = new int[queries.length];
        HashMap<Integer,Integer> map1 =  new HashMap<>();//行
        HashMap<Integer,Integer> map2 =  new HashMap<>();//列
        HashMap<Integer,Integer> map3 =  new HashMap<>();//捺
        HashMap<Integer,Integer> map4 =  new HashMap<>();//撇
        for (int[] lamp:lamps) {
            if(!map.containsKey(lamp[0]) || !map.get(lamp[0]).contains(lamp[1])) {
                map.putIfAbsent(lamp[0],new HashSet<>());
                map.get(lamp[0]).add(lamp[1]);

                map1.put(lamp[0],map1.getOrDefault(lamp[0],0) + 1);
                map2.put(lamp[1],map2.getOrDefault(lamp[1],0) + 1);
                map3.put(lamp[1] - lamp[0],map3.getOrDefault(lamp[1] - lamp[0],0) + 1);
                map4.put(lamp[1] + lamp[0],map4.getOrDefault(lamp[1] + lamp[0],0) + 1);
            }
        }
        for (int index = 0; index < queries.length; index++) {
            int[] query = queries[index];
            res[index] = (map1.getOrDefault(query[0],0) > 0 ||
                          map2.getOrDefault(query[1],0) > 0 ||
                          map3.getOrDefault(query[1] - query[0],0) > 0 ||
                          map4.getOrDefault(query[1] + query[0],0) > 0 ) ? 1 : 0;
            for (int i = Math.max(query[0] - 1, 0); i <= Math.min(query[0] + 1 , n - 1); i++) {
                for (int j = Math.max(query[1] - 1, 0); j <= Math.min(query[1] + 1 , n - 1); j++) {
                    if(map.containsKey(i) && map.get(i).contains(j)) {
                        mapMinus(map1,i);
                        mapMinus(map2,j);
                        mapMinus(map3,j-i);
                        mapMinus(map4,j+i);
                        HashSet<Integer> set = map.get(i);
                        set.remove(j);
                        if(set.isEmpty())
                            map.remove(i);
                    }
                }
            }
        }
        return res;
    }

    private void mapMinus(HashMap<Integer,Integer> map,Integer key) {
        Integer n = map.get(key);
        if(n == 1)  map.remove(key);
        else map.put(key,n-1);
    }



}

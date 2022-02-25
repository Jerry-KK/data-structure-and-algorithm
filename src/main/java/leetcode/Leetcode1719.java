package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/2/16 21:17
 */
//todo
public class Leetcode1719 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Integer i = new Integer("1");
    }

    public int checkWays(int[][] pairs) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] pair:pairs) {
            map.putIfAbsent(pair[0],new HashSet<>());
            map.putIfAbsent(pair[1],new HashSet<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int n = map.size();
        Set<Integer> roots = new HashSet<>();
        for (Map.Entry<Integer,Set<Integer>> entry:map.entrySet()) {
            if(entry.getValue().size() == n-1) {
                roots.add(entry.getKey());
            }
        }
        if(roots.isEmpty()) {
            return 0;
        }
        int res = roots.size() == 1 ? 1 : 2;
        for (int node:map.keySet()) {
            if(roots.contains(node)) {
                continue;
            }
            Set<Integer> neighbors = map.get(node);
            int parent = -1;
            int pSize = n-1;
            int size = neighbors.size();
            for (Integer neighbor:neighbors) {
                int nSize = map.get(neighbor).size();
                if(nSize >= size && nSize <= pSize) {
                    parent = neighbor;
                    pSize = nSize;
                }
            }
            if(parent == -1) {
                return 0;
            }
            Set<Integer> set = new HashSet<>(map.get(parent));
            set.add(parent);
            if(!set.containsAll(map.get(node))) {
                return 0;
            }
            if(pSize == size) {
                res = 2;
            }
        }
        return res;
    }

}

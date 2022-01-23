package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author lethe
 * @date 2022/1/23 23:49
 */
public class Leetcode2034 {

    class StockPrice {

        int newTime;
        HashMap<Integer,Integer> hashMap;
        TreeMap<Integer,Integer> treeMap;

        public StockPrice() {
            hashMap = new HashMap<>();
            treeMap = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            newTime = Math.max(newTime,timestamp);
            if(hashMap.containsKey(timestamp)) {
                Integer oldValue = hashMap.get(timestamp);
                Integer times = treeMap.get(oldValue);
                if(times == 1)
                    treeMap.remove(oldValue);
                else
                    treeMap.put(oldValue,times-1);
            }
            hashMap.put(timestamp,price);
            treeMap.put(price,treeMap.getOrDefault(price,0)+1);
        }

        public int current() {
            return hashMap.get(newTime);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }
}

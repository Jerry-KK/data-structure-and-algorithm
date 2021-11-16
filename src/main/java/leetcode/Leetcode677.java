package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/11/14 22:28
 */
public class Leetcode677 {

    public static void main(String[] args) {
        Leetcode677 body = new Leetcode677();
        MapSum m = body.new MapSum();
        m.insert("apple",2);
        m.insert("app",3);
        int ap = m.sum("ap");
        System.out.println(ap);
    }

    class MapSum {
        Map<String,Integer> map;
        Map<String,Integer> sumMap;

        public MapSum() {
            map = new HashMap<>();
            sumMap = new HashMap<>();
        }

        public void insert(String key, int val) {
            int sv = val - map.getOrDefault(key,0);
            map.put(key,val);
            for (int i = 1; i <= key.length(); ++i) {
                sumMap.compute(key.substring(0,i),(k,v) -> {
                    if(v == null)
                        v = sv;
                    else
                        v += sv;
                    return v;
                });
            }
        }

        public int sum(String prefix) {
            return sumMap.getOrDefault(prefix,0);
        }
    }
}

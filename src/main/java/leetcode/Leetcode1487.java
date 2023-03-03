package leetcode;

import java.util.HashMap;

/**
 * @author lethe
 * @date 2023/3/3 17:06
 */
public class Leetcode1487 {

    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        int l = names.length;
        for (int i = 0; i < l; i++) {
            String name = names[i];
            if(map.containsKey(name)) {
                Integer n = map.get(name);
                String s = name;
                while (map.containsKey(s)) {
                    s = name + "(" + n + ")";
                    map.put(name, ++n);
                }
                map.put(s, 1);
                names[i] = s;
            } else {
                map.put(name, 1);
            }
        }
        return names;
    }

}

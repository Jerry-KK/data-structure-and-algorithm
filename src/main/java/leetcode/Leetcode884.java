package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/1/30 22:41
 */
public class Leetcode884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        s1 = s1 + " " + s2;
        String[] arr1 = s1.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s:arr1) {
            map.putIfAbsent(s,0);
            map.put(s,map.get(s) + 1);
        }
        String[] arr = map
                .entrySet()
                .stream()
                .filter(entry->entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
        return arr;
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        s1 = s1 + " " + s2;
        String[] arr = s1.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s:arr)
            map.put(s,map.getOrDefault(s,0) + 1);
        List<String> list = new ArrayList<>();
        map.forEach((k,v)->{
            if(v == 1)
                list.add(k);
        });
        return list.toArray(new String[0]);
    }

    public String[] uncommonFromSentences3(String s1, String s2) {
        s1 = s1 + " " + s2;
        String[] arr = s1.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s:arr)
            map.put(s,map.getOrDefault(s,0) + 1);
        map.entrySet().removeIf(next -> next.getValue() != 1);
        return map.keySet().toArray(new String[0]);
    }

}

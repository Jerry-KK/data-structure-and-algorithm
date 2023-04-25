package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2023/4/25 11:18
 */
public class Leetcode2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new HashMap<>();
        int l = names.length;
        for(int i = 0; i < l;++i)
            map.put(heights[i], names[i]);
        Arrays.sort(heights);
        for(int i = 0; i < l;++i)
            names[i] = map.get(heights[l-1-i]);
        return names;
    }

    public String[] sortPeople2(String[] names, int[] heights) {
        int l = names.length;
        Integer[] tmp = new Integer[l];
        for (int i = 0; i < l; i++)
            tmp[i] = i;
        Arrays.sort(tmp,(a,b) -> heights[b] - heights[a]);
        String[] res = new String[l];
        for (int i = 0; i < l; i++)
            res[i] = names[tmp[i]];
        return res;
    }

    public static void main(String[] args) {
        Leetcode2418 body = new Leetcode2418();
        String[] names = {"Mary","John","Emma"};
//        int[] heights = {180,165,170};
        int[] heights = {155,165,150};
        body.sortPeople3(names, heights);
    }

    public String[] sortPeople3(String[] names, int[] heights) {
        helper(names, heights, 0, names.length-1);
        return names;
    }

    private void helper(String[] names, int[] heights, int s , int e) {
        if(s < e) {
            int i = s+1;
            int v = heights[s];
            for (int j = s+1; j <= e; j++) {
                if(heights[j] > v) {
                    int tmp = heights[j];
                    heights[j] = heights[i];
                    heights[i] = tmp;

                    String t2 = names[j];
                    names[j] = names[i];
                    names[i] = t2;
                    ++i;
                }
            }
            int tmp = heights[i-1];
            heights[i-1] = heights[s];
            heights[s] = tmp;

            String t2 = names[i-1];
            names[i-1] = names[s];
            names[s] = t2;
            helper(names, heights, s , i-2);
            helper(names, heights, i , e);
        }
    }


}

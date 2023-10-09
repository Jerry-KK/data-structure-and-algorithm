package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode2578 {

    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num%10);
            num /= 10;
        }
        list.sort(Integer::compare);
        int v1 = 0, v2 = 0, l = list.size(), i =1;
        for (; i < l; i+=2) {
            v1 = v1 * 10 + list.get(i-1);
            v2 = v2 * 10 + list.get(i);
        }
        if(i == l)
            v1 = v1 * 10 + list.get(l-1);
        return v1 + v2;
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/12/24 23:05
 */
public class Leetcode1705 {

    public static void main(String[] args) {
        Leetcode1705 body = new Leetcode1705();
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        int res = body.eatenApples(apples, days);
        System.out.println(res);
    }

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        for (int i = 0; i < n; i++) {
            days[i] += i;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(days[i],0);
            map.put(days[i],map.get(days[i]) + apples[i]);
        }
        int res = -1;
        int sum = 0;
        while (res <= sum) {
            res++;
            if(res < n)
                sum += apples[res];
            if(map.get(res) != null)
                sum -= map.get(res);
        }
        return res;
    }

}

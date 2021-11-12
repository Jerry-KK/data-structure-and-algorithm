package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/11/12 17:08
 */
public class Leetcode375 {

    public int getMoneyAmount(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            n = n>>1;
            list.add(n);
        }
        int sum = 0;
        int j = 0;
        for (int i : list) {
            sum+=(i+j);
            j = i;
        }
        return sum;
    }

}

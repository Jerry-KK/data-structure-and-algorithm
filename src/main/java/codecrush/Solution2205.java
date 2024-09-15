package codecrush;

import java.util.ArrayList;
import java.util.List;

public class Solution2205 {

    List<Integer> joinBoard(int s, int t, int k){
        List<Integer> list = new ArrayList<>();
        if (s > t) {
            int tmp = s;
            s = t;
            t = tmp;
        }
        int v = t - s;
        int sum = s*k;
        list.add(sum);
        for (int i = 0; i < k; i++) {
            sum += v;
            list.add(sum);
        }
        return list;
    }

}

package codecrush;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Solution2206 {

    public static void main(String[] args) {
        System.out.println(findMonotoneIncreasingNum(10));
        System.out.println(findMonotoneIncreasingNum(236));
        System.out.println(findMonotoneIncreasingNum(552));
        System.out.println(findMonotoneIncreasingNum(0));
        System.out.println(findMonotoneIncreasingNum(1));
        System.out.println(findMonotoneIncreasingNum(111));
        System.out.println(findMonotoneIncreasingNum(2147483647));
    }

    public static int findMonotoneIncreasingNum(int n) {
        if (n < 10)
            return n;
        int m = n;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        while (n > 0) {
            list.add(n%10);
            n/=10;
        }
        int l = list.size();
        int i = l-2, j = l-1;
        int v = list.get(j);
        boolean flag = true;
        for (; i >= 0; --i) {
            if (list.get(i) > v) {
                v = list.get(i);
                j = i;
            } else if (list.get(i) < v) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return m;
        }
        int a = 10;
        for (int k = 1; k < j; k++) {
            a *= 10;
        }
        m = (m/a - 1) * a + a - 1;
        return m;
    }

}

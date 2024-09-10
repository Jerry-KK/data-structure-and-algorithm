package codecrush;

import java.util.ArrayList;
import java.util.List;

public class Solution2110 {

    public static void main(String[] args) {
        System.out.println(yanghui(2));
    }

    public static List<Integer> yanghui(int n) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n+1];
        int[] arr2 = new int[n+1];
        arr[1] = 1;
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j <= n; j++)
                arr2[j] = arr[j-1] + arr[j];
            int[] temp = arr2;
            arr2 = arr;
            arr = temp;
        }
        for (int i = 1; i <= n; i++)
            list.add(arr[i]);
        return list;
    }

}

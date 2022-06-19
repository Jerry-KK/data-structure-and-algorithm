package leetcode.efficientwinning;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/3/10 21:42
 */
public class Leetcode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        int[][] arr = new int[2][rowIndex+1];
        arr[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            arr[i&1][0] = arr[(i-1)&1][0];
            for (int j = 1; j <= i; j++) {
                arr[i&1][j] = arr[(i-1)&1][j] + arr[(i-1)&1][j-1];
            }
        }
        int row = rowIndex&1;
        for (int v:arr[row]) {
            ans.add(v);
        }
        return ans;
    }

}

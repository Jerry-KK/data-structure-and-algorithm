package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lethe
 * @date 2022/2/15 7:24
 */
public class Leetcode1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length,n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            row[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i],matrix[i][j]);
                col[j] = Math.max(col[j],matrix[i][j]);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int a:row)
            set.add(a);
        for (int a:col)
            if(set.contains(a))
                list.add(a);
        return list;
    }

}

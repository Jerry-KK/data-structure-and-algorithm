package leetcode.weeklycontest.weeklycontrst347;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2023/5/28 10:16
 */
public class Contrst347_2 {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{3,1,5},{3,2,1}};
        int[][] res = differenceOfDistinctValues(grid);
        System.out.println(res);
        System.out.println("123");
    }

    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] topLeft = new int[m][n];
        int[][] bottomRight = new int[m][n];
        for (int i = 0; i < m-1; i++) {
            Set<Integer> set = new HashSet<>();
            int a = i;
            int b = 0;
            while (a + 1 < m && b + 1 < n) {
                set.add(grid[a][b]);
                topLeft[a+1][b+1] = set.size();
                ++a;
                ++b;
            }
        }
        for (int i = 1; i < n-1; i++) {
            Set<Integer> set = new HashSet<>();
            int a = 0;
            int b = i;
            while (a + 1 < m && b + 1 < n) {
                set.add(grid[a][b]);
                topLeft[a+1][b+1] = set.size();
                ++a;
                ++b;
            }
        }
        for (int i = 1; i < m; i++) {
            int a = i;
            int b = n-1;
            Set<Integer> set = new HashSet<>();
            while (a >= 1 && b >= 1) {
                set.add(grid[a][b]);
                bottomRight[a-1][b-1] = set.size();
                --a;
                --b;
            }
        }
        for (int i = 0; i < n-1; i++) {
            int a = m-1;
            int b = i;
            Set<Integer> set = new HashSet<>();
            while (a >= 1 && b >= 1) {
                set.add(grid[a][b]);
                bottomRight[a-1][b-1] = set.size();
                --a;
                --b;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.abs(topLeft[i][j] - bottomRight[i][j]);
            }
        }
        return ans;
    }



}

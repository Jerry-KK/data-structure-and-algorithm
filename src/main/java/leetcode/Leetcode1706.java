package leetcode;

/**
 * @author lethe
 * @date 2022/2/24 9:43
 */
public class Leetcode1706 {

    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
        for (int x = 0; x < m; x++) {
            for (int idx = 0; idx < n; idx++) {
                int y = answer[idx];
                if(y != -1) {
                    int v = grid[x][y];
                    if(v == 1 && y+1 == n || v == -1 && y == 0 || v != grid[x][y+v]) {
                        answer[idx] = -1;
                    }else {
                        answer[idx] += v;
                    }
                }
            }
        }
        return answer;
    }

}

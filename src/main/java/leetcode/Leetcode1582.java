package leetcode;

/**
 * @author lethe
 * @date 2022/9/4 2:23
 */
public class Leetcode1582 {

    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[] rows = new int[r];
        int[] cols = new int[c];
        for (int i = 0; i < r ; i++)
            for (int j = 0; j < c; j++)
                if (mat[i][j] == 1 && ++rows[i] > 0)
                    ++cols[j];
        int ans = 0;
        for (int i = 0; i < r ; i++)
            for (int j = 0; j < c; j++)
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1)
                    ++ans;
        return ans;
    }

}

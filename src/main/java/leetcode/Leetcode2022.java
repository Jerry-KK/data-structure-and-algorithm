package leetcode;

/**
 * @author lethe
 * @date 2022/1/1 12:45
 */
public class Leetcode2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length)
            return new int[0][0];
        int[][] arr = new int[m][n];
        for (int i = 0; i < original.length; i++)
            arr[i/n][i%n] = original[i];
        return arr;
    }

    public int[][] construct2DArray2(int[] original, int m, int n) {
        if(m * n != original.length)
            return new int[0][0];
        int[][] arr = new int[m][n];
        for (int i = 0,idx =0; i < original.length;++idx)
            for (int j = 0; j < n; j++)
                arr[idx][j] = original[i++];
        return arr;
    }

}

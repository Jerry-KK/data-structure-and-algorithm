package codecrush;


public class Solution2111 {

    public void setZeros(int[][] matrix, int n, int m) {
        int[] arr = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    arr[i] = 1;
                    arr2[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i] == 1 || arr2[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

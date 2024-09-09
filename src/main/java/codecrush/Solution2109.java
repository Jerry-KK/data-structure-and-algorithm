package codecrush;

public class Solution2109 {

    private static final int[][] arr = {{-1,0},{0,1},{1,0},{0,-1}};

    public int clean(int[][] matrix, int n, int m) {
        int x = (n-1)>>1;
        int y = (m-1)>>1;
        int res = matrix[x][y];
        matrix[x][y] = 0;
        while (true) {
            int max = 0;
            int idx = -1;
            for (int i = 0; i < arr.length; i++) {
                if (x + arr[i][0] >= n || x + arr[i][0] < 0 || y + arr[i][1] >=m || y + arr[i][1] < 0)
                    continue;
                if(matrix[x + arr[i][0]][y+arr[i][1]] > max){
                    max = matrix[x + arr[i][0]][y+arr[i][1]];
                    idx = i;
                }
            }
            if(idx == -1){
                break;
            }
            res += max;
            x = x + arr[idx][0];
            y = y + arr[idx][1];
            matrix[x][y] = 0;
        }
        return res;
    }


}

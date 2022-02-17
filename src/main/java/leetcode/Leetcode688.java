package leetcode;

/**
 * @author lethe
 * @date 2022/2/17 16:42
 */
public class Leetcode688 {
    public static void main(String[] args) {
        Leetcode688 body = new Leetcode688();
        double v = body.knightProbability3(8, 30, 6, 4);
        System.out.println(v);

    }

    //回溯，超时
    public double knightProbability(int n, int k, int row, int column) {
        double[] res = {0};
        helper(n,k,row,column,res);
        return res[0]/Math.pow(8,k);
    }

    private void helper(int n,int k,int row, int column,double[] res) {
        if(row >= 0 && row < n && column >= 0 && column < n) {
            if(k == 0) {
                ++res[0];
            }else {
                helper(n,k-1,row+1,column+2,res);
                helper(n,k-1,row-1,column+2,res);
                helper(n,k-1,row+1,column-2,res);
                helper(n,k-1,row-1,column-2,res);
                helper(n,k-1,row+2,column+1,res);
                helper(n,k-1,row-2,column+1,res);
                helper(n,k-1,row+2,column-1,res);
                helper(n,k-1,row-2,column-1,res);
            }
        }
    }

    //动态规划，dp中保存次数，最后计算概率，会越界
    public double knightProbability2(int n, int k, int row, int column) {
        int l = n * n;
        long[][] arr = new long[k+1][l];
        arr[0][row * n + column] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n * n; j++) {
                long v = arr[i][j];
                if(v != 0) {
                    if(j-2*n-1 > 0)
                        arr[i+1][j-2*n-1] += v;
                    if(j-2*n+1 > 0)
                        arr[i+1][j-2*n+1] += v;
                    if(j-n-2 > 0)
                        arr[i+1][j-n-2] += v;
                    if(j-n+2> 0 && j-n+2 < l)
                        arr[i+1][j-n+2] += v;
                    if(j+n-2> 0 && j+n-2 < l)
                        arr[i+1][j+n-2] += v;
                    if(j+n+2 < l)
                        arr[i+1][j+n+2] += v;
                    if(j+2*n-1 < l)
                        arr[i+1][j+2*n-1] += v;
                    if(j+2*n+1 < l)
                        arr[i+1][j+2*n+1] += v;
                }
            }
        }
        long r = 0;
        for (long v:arr[k])
            r+=v;
        System.out.println(r);
        return r/Math.pow(8,k);
    }

    //动态规划，dp中保存概率
    public double knightProbability3(int n, int k, int row, int column) {
        double[][][] arr = new double[k+1][n][n];
        arr[0][row][column] = 1;
        for (int i = 0; i < k; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    double v = arr[i][r][c];
                    if(v != 0) {
                        v = v/8;
                        if(r-2 >= 0 && c-1>=0 )
                            arr[i+1][r-2][c-1] += v;
                        if(r-2 >= 0 && c+1<n )
                            arr[i+1][r-2][c+1] += v;
                        if(r-1 >= 0 && c-2>=0 )
                            arr[i+1][r-1][c-2] += v;
                        if(r-1 >= 0 && c+2<n )
                            arr[i+1][r-1][c+2] += v;
                        if(r+1 < n && c-2 >= 0 )
                            arr[i+1][r+1][c-2] += v;
                        if(r+1 < n && c+2 < n )
                            arr[i+1][r+1][c+2] += v;
                        if(r+2 < n && c-1 >= 0 )
                            arr[i+1][r+2][c-1] += v;
                        if(r+2 < n && c+1 < n )
                            arr[i+1][r+2][c+1] += v;
                    }
                }
            }
        }
        double r = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r+=arr[k][i][j];
        return r;
    }

}

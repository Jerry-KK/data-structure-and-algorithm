package chapter42_dynamic_programming;

/**
 * @author lethe
 * @date 2021/8/17 20:45
 */
public class LevenshteinDistanceByDynamic {

    private static char[] a = "mitcmu".toCharArray();
    private static char[] b = "mtacnu".toCharArray();
    private static int n = 6;
    private static int m = 6;

    //调用方法 lwstBT(0,0,0)
    public static int lwstBT(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        // 初始化第0行:a[0..0]与b[0..j]的编辑距离
        for (int j = 0; j < n; j++) {
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        // 初始化第0列:a[0..i]与b[0..0]的编辑距离
        for (int i = 0; i < m; i++) {
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(a[i] == b[j]) {
                    minDist[i][j] = getMin(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]);
                }else {
                    minDist[i][j] = getMin(minDist[i-1][j],minDist[i][j-1],minDist[i-1][j-1])+1;
                }
            }
        }
        return minDist[n-1][m-1];
    }

    private static int getMin(int a, int b, int c) {
        if(a < b)
            return a < c ? a : c;
        else
            return b < c ? b : c;
    }

    public static void main(String[] args) {
        System.out.println(lwstBT(a, n, b, m));
    }

}

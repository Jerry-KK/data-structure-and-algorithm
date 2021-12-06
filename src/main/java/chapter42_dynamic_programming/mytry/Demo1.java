package chapter42_dynamic_programming.mytry;

/**
 * @author koujn
 * @date 2021/12/6 14:17
 */
public class Demo1 {

    //回溯
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE;
    //调用方式lwstBT(0,0,0);
    public void lwstBT(int i,int j,int edist) {
        if(i == n || j == m) {
            if(i < n)
                edist += n-i;
            if(j < m)
                edist += m-j;
            if(edist < minDist)
                minDist = edist;
        }else {
            if(a[i] == b[j]){
                lwstBT(i+1,j+1,edist);
            }else {
                lwstBT(i+1,j,edist+1);
                lwstBT(i,j+1,edist+1);
                lwstBT(i+1,j+1,edist+1);
            }
        }
    }

    //动态规划
    public int lwstDP(char[] a, int n , char[] b, int m) {
        int[][] minDist = new int[n][m];
        minDist[0][0] = a[0] == b[0] ? 0 : 1;
        for (int j = 1; j < m; j++) {
            if(a[0] == b[j]) {
                minDist[0][j] = j;
            }else {
                minDist[0][j] = minDist[0][j-1]+1;
            }
        }
        for (int i = 1; i < n; i++) {
            if(a[i] == b[0]) {
                minDist[i][0] = i;
            }else {
                minDist[i][0] = minDist[i-1][0]+1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i] == b[j]) {
                    minDist[i][j] = Math.min(
                            Math.min(minDist[i-1][j]+1,minDist[i][j-1]+1),
                            minDist[i-1][j-1]);
                }else {
                    minDist[i][j] = Math.min(
                            Math.min(minDist[i-1][j]+1,minDist[i][j-1]+1),
                            minDist[i-1][j-1]+1);
                }
            }
        }
        return minDist[n-1][m-1];
    }
}

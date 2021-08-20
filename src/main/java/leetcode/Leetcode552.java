package leetcode;

/**
 * @author koujn
 * @date 2021/8/18 9:54
 */
public class Leetcode552 {

    public static void main(String[] args) {
        int l = test(10101);
        System.out.println(l);
    }

    /**
     *  （i,j）       i表示缺勤天数，j表示迟到天数
     *  数组长度为6表示：
     *  0       1       2      3       4       5
     *  (0,0)   (0,1)   (0,2)  (1,0)   (1,1)   (1,2)
     */
    private static int test(int n) {
        long[][] status = new long[n][6];
        status[0][0] = 1L;
        status[0][1] = 1L;
        status[0][3] = 1L;
        for (int i = 1; i < n; i++) {
            status[i][0] = (status[i-1][0] + status[i-1][1] + status[i-1][2])%1000000007L;
            status[i][1] = status[i-1][0];
            status[i][2] = status[i-1][1];
            status[i][3] = (status[i-1][0] + status[i-1][1] + status[i-1][2] + status[i-1][3] + status[i-1][4] + status[i-1][5])%1000000007L;
            status[i][4] = status[i-1][3];
            status[i][5] = status[i-1][4];
        }
        long sum = 0;
        for (int k = 0; k < 6; k++) {
            sum+=status[n-1][k];
        }
        return (int)(sum%1000000007L);
    }

    private static long test2(int n) {
        long[][] status = new long[n][6];
        status[0][0] = 1L;
        status[0][1] = 1L;
        status[0][3] = 1L;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                if(status[i-1][j] != 0) {
                    int a = j/3;
                    int l = j%3;
                    //这里计算未考虑long范围不够问题
                    //缺勤
                    if(a == 0)  status[i][3] += status[i-1][j];
                    //迟到
                    if(l < 2)   status[i][j+1] += status[i-1][j];
                    //到场
                    status[i][j-l] += status[i-1][j];
                }
            }
        }
        long sum = 0;
        for (int k = 0; k < 6; k++) {
            sum+=(long)status[n-1][k];
        }
        return sum;
    }

}

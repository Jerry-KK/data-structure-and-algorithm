package chapter42_dynamic_programming;

/**
 * @author lethe
 * @date 2021/8/17 20:45
 */
public class LevenshteinDistanceByBacktracking {

    private static char[] a = "mitcmu".toCharArray();
    private static char[] b = "mtacnu".toCharArray();
    private static int n = 6;
    private static int m = 6;
    //存储结果
    private static int minDist = Integer.MAX_VALUE;

    //调用方法 lwstBT(0,0,0)
    public static void lwstBT(int i, int j, int edist) {
        if(i == n || j == m) {
            if(i < n) edist+=(m-j);
            if(j < m) edist+=(m-i);
            if(edist < minDist) minDist = edist;
            return;
        }
        if(a[i] == b[j]) {
            lwstBT(i+1,j+1,edist);
        }else {
            lwstBT(i+1,j,edist+1);
            lwstBT(i,j+1,edist+1);
            lwstBT(i+1,j+1,edist+1);
        }
    }

    public static void main(String[] args) {
        lwstBT(0,0,0);
        System.out.println(minDist);
    }

}

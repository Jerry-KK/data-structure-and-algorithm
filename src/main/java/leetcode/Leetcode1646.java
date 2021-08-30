package leetcode;

/**
 * @author koujn
 * @date 2021/8/23 15:48
 */
public class Leetcode1646 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(getMaximumGenerated2(n));
    }

    public static int getMaximumGenerated(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return getN(n%2 == 0 ? n-1 : n);
    }

    public static int getN(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int a = n/2;
        int b = n%2;
        if(b == 0) {
            return getN(a);
        }else {
            return getN(a) + getN(a+1);
        }
    }

    public static int getMaximumGenerated2(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if(i%2 == 0) {
                arr[i] = arr[i/2];
            }else {
                arr[i] = arr[i/2] + arr[i/2+1];
                if(max < arr[i]) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

}

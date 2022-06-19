package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/7 19:05
 */
public class Leetcode509 {

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        int[] arr = {0,1};
        for (int i = 2; i < n; i++) {
            arr[i%2] = arr[0] + arr[1];
        }
        return arr[0] + arr[1];
    }

}

package leetcode;

/**
 * @author koujn
 * @date 2021/11/15 9:27
 */
public class Leetcode319 {

    public static void main(String[] args) {
        Leetcode319 body = new Leetcode319();
        int i = body.bulbSwitch(99999999);
        System.out.println(i);
    }

    public int bulbSwitch(int n) {
        boolean[] arr = new boolean[n];
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j < n; ) {
                arr[j] = !arr[j];
                j+=i;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            if(!arr[i])
                ++res;
        return res;
    }

    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}

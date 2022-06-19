package leetcode;

/**
 * @author lethe
 * @date 2022/3/13 15:52
 */
public class Leetcode393 {

    public static void main(String[] args) {
        int[] data = {197,130,1};
        Leetcode393 body = new Leetcode393();
        boolean res = body.validUtf8(data);
        System.out.println(res);
        int x = 1;
        if(((x>>7) &1) ==0  || ((x>>6) & 1) == 1) {
            System.out.println(x);
        }
    }

    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int n = 0;
            while ((data[i] & (1<<(7-n))) != 0) {
                ++n;
            }
            if(i+n> data.length || n == 1 || n > 4) {
                return false;
            }
            for (int k = 1; k < n; k++) {
                if(((data[i+k]>>7) &1) ==0  || ((data[i+k]>>6) & 1) == 1) {
                    return false;
                }
            }
            if(n == 0)
                ++i;
            i += n;
        }
        return true;
    }
}

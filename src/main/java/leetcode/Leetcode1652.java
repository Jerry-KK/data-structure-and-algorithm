package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2022/9/24 21:56
 */
public class Leetcode1652 {

    public static void main(String[] args) {
        Leetcode1652 body = new Leetcode1652();
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] decrypt = body.decrypt(code, k);
        for (int d : decrypt) {
            System.out.println(d);
        }
    }

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int l = code.length;
        int[] res = new int[l];
        int idx = method(code, k, res);
        for (int i = 1; i < l && (res[i] = res[i - 1] + (k > 0 ? code[idx + 1 == code.length ? 0 : idx + 1] - code[i] : code[i - 1] - code[idx])) > 0; i++, idx = (idx + 1 == l ? 0 : idx + 1)) ;
        return res;
    }


    private int method(int[] code, int k, int[] sum) {
        int l = code.length, idx = getNext(0, k, l), n = 0;
        for (int i = 0; i < Math.abs(k) && (n = n + code[idx]) > 0; i++, idx = getNext(idx, k, l)) ;
        sum[0] = n;
        return getNext(idx, -k, l);
    }

    private int getNext(int idx, int k, int l) {
        return k > 0 ? (idx + 1 == l ? 0 : idx + 1) : (idx == 0 ? l - 1 : idx - 1);
    }

}

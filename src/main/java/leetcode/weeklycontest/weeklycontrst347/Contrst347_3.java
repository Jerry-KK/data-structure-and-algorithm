package leetcode.weeklycontest.weeklycontrst347;

/**
 * @author lethe
 * @date 2023/5/28 10:16
 */
public class Contrst347_3 {
    public static void main(String[] args) {
        System.out.println(minimumCost("010101"));
    }

    //todo 没解决
    public static long minimumCost(String s) {
        int n = s.length();
        long[] l0 = new long[n];
        long[] r0 = new long[n];
        long[] l1 = new long[n];
        long[] r1 = new long[n];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(cs[i] == '0') {
                int j = i;
                while (j+1 < n && cs[j+1] == '0') {
                    ++j;
                }
                l0[i] = j+1;
                i = j;
            } else {
                int j = i;
                while (j+1 < n && cs[j+1] == '1') {
                    ++j;
                }
                l1[i] = j+1;
                i = j;
            }
        }

        for (int i = n-1; i >= 0; --i) {
            if(cs[i] == '0') {
                int j = i;
                while (j>=1  && cs[j-1] == '0') {
                    --j;
                }
                r0[i] = n-j;
                i = j;
            } else {
                int j = i;
                while (j>=1  && cs[j-1] == '1') {
                    --j;
                }
                r1[i] = n-j;
                i = j;
            }
        }
        for (int i = 1; i < n; i++) {
            l0[i] += l0[i-1];
            l1[i] += l1[i-1];
        }
        for (int i = n-2; i >=0 ; --i) {
            r0[i] += r0[i+1];
            r1[i] += r1[i+1];
        }
        long res = Math.min(l0[n-1], r1[n-1]);
        res = Math.min(res, Math.min(r0[0], r1[0]));
        for (int i = 0; i < n-1; i++) {
            res = Math.min(Math.min(l0[i]+r0[i+1], l1[i]+r1[i+1]) , res);
        }
        return res;
    }
}

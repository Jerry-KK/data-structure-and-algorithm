package leetcode.weeklycontest.weeklycontest298;

/**
 * @author lethe
 * @date 2022/6/19 10:22
 */
/**
 *  小于等于 K 的最长二进制子序列
 *  1:13:42  1次错误尝试
 */
public class Contest298_3 {

    public static void main(String[] args) {
        Contest298_3 body = new Contest298_3();
        int i = body.longestSubsequence("1111", 9);
        System.out.println(i);
    }

    public int longestSubsequence(String s, int k) {
        String s2 = getL(k);
        int l = s.length();
        int l2 = s2.length();
        if(l < l2)
            return l;
        int res = 0;
        boolean flag = false;
        for (int p = l2; p >= 1 ; --p) {
            for (int i = l  - p; i >= 0 ; --i) {
                if(method1(s,k,i,p))  {
                    res = p;
                    for (int j = 0; j < i; j++) {
                        if(s.charAt(j) == '0') {
                            ++res;
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        int n = 0;
        for (char c:s.toCharArray()) {
            if(c == '0') {
                ++n;
            }
        }
        n = Math.max(n ,1);
        return Math.max(res,n);
    }
    
    private String getL(int k) {
        StringBuilder sb = new StringBuilder();
        while ( k > 0) {
            sb.append(k%2);
            k/=2;
        }
        sb.reverse();
        return sb.toString();
    }

    private boolean method1( String s, int  k, int idx,int p) {
        int v = 0;
        for (int i = 0; i < p; i++)
            v = s.charAt(i + idx) == '1' ?  v * 2 + 1 : v * 2;
        return v <= k;
    }

}

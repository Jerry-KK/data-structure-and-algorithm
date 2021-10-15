package leetcode;

/**
 * @author koujn
 * @date 2021/10/15 9:14
 */
public class Leetcode38 {

    public static void main(String[] args) {
        Leetcode38 body = new Leetcode38();
        String s = body.countAndSay(4);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; ++i) {
            res = myGet(res);
        }
        return res;
    }

    public String myGet(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int n = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == c) {
                ++n;
            }else {
                res.append(n).append(c);
                c = chars[i];
                n = 1;
            }
        }
        res.append(n).append(c);
        return res.toString();
    }
}

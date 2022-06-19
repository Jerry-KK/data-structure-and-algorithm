package leetcode;


/**
 * @author lethe
 * @date 2022/3/1 21:54
 */
public class Leetcode6 {
    public static void main(String[] args) {
        Leetcode6 body = new Leetcode6();
        String ans = body.convert("PAYPALISHIRING", 3);
        System.out.println(ans);
    }

    public String convert(String s, int numRows) {
        int idx = 0,l = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        while (idx < l) {
            for (int i = 0; i < numRows && idx < l; i++,++idx) {
                sbs[i].append(s.charAt(idx));
            }
            for (int i = numRows-2; i > 0  && idx < l ; --i,++idx) {
                sbs[i].append(s.charAt(idx));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb:sbs) {
            ans.append(sb.toString());
        }
        return ans.toString();
    }
}

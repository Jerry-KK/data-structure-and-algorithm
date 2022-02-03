package leetcode;

/**
 * @author lethe
 * @date 2022/2/1 13:38
 */
public class Leetcode1763 {

    public static void main(String[] args) {
        Leetcode1763 body = new Leetcode1763();
        String res = body.longestNiceSubstring("YazaAay");
        System.out.println(res);
    }

    public String longestNiceSubstring(String s) {
        for (int i = s.length(); i > 1 ; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                String str = s.substring(j, j+i);
                if(method(str)) {
                    return str;
                }
            }
        }
        return "";
    }

    public boolean method(String s) {
        int a = 0,b = 0;
        for (char c:s.toCharArray()) {
            if(c > 'Z') {
                a |=  1 << (c-'a');
            }else {
                b |=  1 << (c-'A');
            }
        }
        return (a^b) == 0;
    }

}

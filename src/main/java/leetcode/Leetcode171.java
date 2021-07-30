package leetcode;

/**
 * @author koujn
 * @date 2021/7/30 9:03
 */
public class Leetcode171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length ; i++) {
            num = num*26 + (chars[i]-64);
        }
        return num;
    }
}

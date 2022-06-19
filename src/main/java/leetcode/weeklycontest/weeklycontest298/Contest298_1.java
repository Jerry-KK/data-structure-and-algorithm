package leetcode.weeklycontest.weeklycontest298;

/**
 * @author lethe
 * @date 2022/6/19 10:22
 */
/**
 *  兼具大小写的最好英文字母
 * 	0:09:16
 */
public class Contest298_1 {
    public static void main(String[] args) {
        String res = greatestLetter("AbCdEfGhIjK");
        System.out.println(res);
    }

    public static String greatestLetter(String s) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        int i  = 0,j = 0;
        int a = 'a';
        int A = 'A';
        for (int c: s.toCharArray()) {
            if(c >= a) {
                i |= 1<<(c - a);
            }else {
                j |= 1<<(c - a);
            }
        }
        i = i & j;
        for (int k = 26; k >= 0 ; --k) {
            if((i>>k & 1) == 1) {
                return String.valueOf((char)(A + k));
            }
        }
        return "";
    }
}

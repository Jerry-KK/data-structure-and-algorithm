package leetcode.weeklycontest.weeklycontrst347;

/**
 * @author lethe
 * @date 2023/5/28 10:16
 */
public class Contrst347_1 {
    public static void main(String[] args) {
        System.out.println("[ "+ removeTrailingZeros("51230100") + " ]");
    }

    public static String removeTrailingZeros(String num) {
        int i = num.length()-1;
        for (; i >= 0 ; --i)
            if(num.charAt(i) != '0')
                break;
        return num.substring(0,i+1);
    }
}

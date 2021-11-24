package leetcode;

/**
 * @author koujn
 * @date 2021/11/24 9:21
 */
public class Leetcode423 {

    /**
     * zero     z
     * one          o   ->  zero -> two -> four
     * two      w
     * three        r   ->  four -> zero
     * four     u
     * five         f   ->  four
     * six      x
     * seven        s  -> five
     * eight    g
     * nine         i -> eight -> five  -> six
     */


     public String originalDigits(String s) {
        int[] arr = new int[26];
        int[] res = new int[10];
        for (int i = 0; i < s.length(); i++)
            ++arr[s.charAt(i)-'a'];
        res[0] = arr['z'-'a'];
        res[2] = arr['w'-'a'];
        res[4] = arr['u'-'a'];
        res[6] = arr['x'-'a'];
        res[7] = arr['s'-'a'] - res[6];
        res[8] = arr['g'-'a'];
        res[1] = arr['o'-'a'] - res[0] - res[4] - res[2];
        res[3] = arr['r'-'a'] - res[0] - res[4];
        res[5] = arr['f'-'a'] - res[4];
        res[9] = arr['i'-'a'] - res[5] - res[6] - res[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++)
        for (int j = 0; j < res[i]; j++)
            sb.append(i);
        return sb.toString();
    }

}

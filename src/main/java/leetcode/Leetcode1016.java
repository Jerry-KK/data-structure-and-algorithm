package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2023/5/11 22:15
 */
public class Leetcode1016 {

    public static void main(String[] args) {
        Leetcode1016 body = new Leetcode1016();
        System.out.println(body.queryString2("0110", 3));
        System.out.println(body.queryString2("0110", 4));
        System.out.println(body.queryString2("10010111100001110010", 10));
        System.out.println(body.queryString2("1111000101", 5));
        System.out.println(body.queryString2("0101011001101101010001001111110111100110110001001111001111111011010010101001011111010010001011011011", 5));
    }

    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> prevSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) == '0' ? 0 : 1;
            int k;
            Set<Integer> tmpSet = new HashSet<>();
            tmpSet.add(v);
            for (int e:prevSet)
                if((k = ((e<<1) + v)) <= n )
                    tmpSet.add(k);
            set.addAll(tmpSet);
            prevSet = tmpSet;
        }
        set.remove(0);
        return set.size() == n;
    }

    public boolean queryString2(String s, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            int v = 0;
            int j = 0;
            int k = 1;
            for (; j < i; j++) {
                v = (v << 1) + (s.charAt(j) == '0' ? 0 : 1);
                k<<=1;
            }
            k>>=1;
            if(v <= n && v > 0)
                set.add(v);
            for (; j < s.length(); j++) {
                if(s.charAt(j - i) == '1')
                    v -= k;
                v = (v << 1) + (s.charAt(j) == '0' ? 0 : 1);
                if(v <= n && v > 0)
                    set.add(v);
            }
        }
        return set.size() == n;
    }

}

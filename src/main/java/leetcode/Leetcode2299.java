package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2023/1/19 11:49
 */
public class Leetcode2299 {

    public static void main(String[] args) {

    }

    public boolean strongPasswordCheckerII(String password) {
        Character[] arr = {'!','@','#','$','%','^','&','*','(',')','-','+'};
        Set<Character> set = new HashSet<>(Arrays.asList(arr));
        boolean f1 = false,f2 = false,f3 = false,f4 = false;
        int l = password.length();
        if(l < 8)
            return false;
        for (int i = 0; i < l; i++) {
            char c = password.charAt(i);
            if(i > 0 && c == password.charAt(i-1))
                return false;
            if(c >= 'a' && c <= 'z')  {
                f1 = true;
                continue;
            }
            if(c >= 'A' && c <= 'Z')  {
                f2 = true;
                continue;
            }
            if(c >= '0' && c <= '9')  {
                f3 = true;
                continue;
            }
            if(set.contains(c))
                f4 = true;
        }
        return f1 && f2 && f3 && f4;
    }

}

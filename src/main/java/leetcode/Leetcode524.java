package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/9/14 9:19
 */
public class Leetcode524 {

    public static void main(String[] args) {
        Leetcode524 body = new Leetcode524();
        String s = "abce";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("abe");
        dictionary.add("abc");
        String longestWord = body.findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        int n = s.length();
        char[] c = s.toCharArray();
        for (String s2:dictionary) {
            char[] c2 = s2.toCharArray();
            int i = 0;
            int j = 0;
            int n2 = s2.length();
            for(;i<n&&j<n2;i++) {
                if(c[i] == c2[j]) {
                    j++;
                }
            }
            if(j == n2) {
                if(n2 > res.length())
                    res = s2;
                else if(n2 == res.length()) {
                    char[] c3 = res.toCharArray();
                    for (i = 0; i < n2; i++) {
                        if(c3[i] < c2[i]){
                            break;
                        }
                        if(c3[i] > c2[i]) {
                            res = s2;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author koujn
 * @date 2021/11/6 15:55
 */
public class Leetcode500 {
/*
    static String s1 = "qwertyuiop";
    static String s2 = "asdfghjkl";
    static String s3 = "zxcvbnm";
    static HashMap<Integer,Integer> map = new HashMap<>();

    static {
        char[] c1 = s1.toCharArray();
        for (int c:c1) {
            map.put(c,1);
            map.put(c - 32,1);
        }
        char[] c2 = s2.toCharArray();
        for (int c:c2) {
            map.put(c,2);
            map.put(c - 32,2);
        }
        char[] c3 = s3.toCharArray();
        for (int c:c3) {
            map.put(c,3);
            map.put(c - 32,3);
        }
    }*/

    public static void main(String[] args) {
        Leetcode500 body = new Leetcode500();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] words1 = body.findWords(words);
        System.out.println(1);
    }

    public String[] findWords(String[] words) {

        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        HashMap<Integer,Integer> map = new HashMap<>();


            char[] c1 = s1.toCharArray();
            for (int c:c1) {
                map.put(c,1);
                map.put(c - 32,1);
            }
            char[] c2 = s2.toCharArray();
            for (int c:c2) {
                map.put(c,2);
                map.put(c - 32,2);
            }
            char[] c3 = s3.toCharArray();
            for (int c:c3) {
                map.put(c,3);
                map.put(c - 32,3);
            }

        ArrayList<String> list = new ArrayList<>();
        for (String s:words) {
            if(s.length() == 0)
                continue;
            boolean flag = true;
            char[] crr = s.toCharArray();
            int n = map.get((int)crr[0]);
            for (int i = 1; i < crr.length; i++) {
                if(map.get((int)crr[i]) != n){
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(s);
        }
        return list.toArray(new String[0]);
    }

}

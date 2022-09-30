package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lethe
 * @date 2022/9/7 19:54
 */
public class Leetcode1592 {

    public static void main(String[] args) {
        //String s = reorderSpaces("  this   is  a sentence ");
        String s = reorderSpaces(" hello");
        System.out.println(s);
    }

    public static String reorderSpaces(String text) {
        int n = 0;
        int i = 0,j = 0;
        List<String> list = new ArrayList<>();
        while (i < text.length()) {
            if(' ' == text.charAt(i)) {
                if(j < i)
                    list.add(text.substring(j,i));
                ++n;
                j = i+1;
            }
            ++i;
        }
        if(j < i)
            list.add(text.substring(j,i));
        int l = list.size();
        if(n == 0 || l == 0)
            return text;
        if(l == 1) {
            char[] crr = new char[n];
            Arrays.fill(crr,' ');
            String s3 = new String(crr);
            return list.get(0) + s3;
        }
        int a = n / (l-1);
        int b = n % (l-1);
        char[] arr = new char[a];
        char[] brr = new char[b];
        Arrays.fill(arr,' ');
        Arrays.fill(brr,' ');
        String s1 = new String(arr);
        String s2 = new String(brr);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int k = 1; k < l; k++)
            sb.append(s1).append(list.get(k));
        sb.append(s2);
        return sb.toString();
    }
}

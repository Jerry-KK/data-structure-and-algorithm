package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/9/9 9:11
 */
public class Leetcode68 {

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        Leetcode68 body = new Leetcode68();
        List<String> list = body.fullJustify(words, 16);
        list.forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        int n = words.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = words[i].length();
        }
        int i = 0;
        while (i < n) {
            int start = i;
            int g = 0;      //个数
            int size = a[i++];
            while (i < n && size+1+a[i] <= maxWidth) {
                size = size+1+a[i++];
                g++;
            }
            //最后一行
            if(i >= n)  {
                StringBuilder r = new StringBuilder(words[start]);
                for (int j = start+1; j < n; j++) {
                    r.append(' ').append(words[j]);
                }
                for (int j = r.length(); j < maxWidth; j++) {
                    r.append(' ');
                }
                res.add(r.toString());
            }else {
                //g为0说明只有一个单次，直接补充空格，同时主要g为0不能做做除法
                if(g == 0) {
                    StringBuilder r = new StringBuilder(words[start]);
                    for (int j = r.length(); j < maxWidth; j++) {
                        r.append(' ');
                    }
                    res.add(r.toString());
                }else {
                    int v1 = (maxWidth-size)/g;
                    int v2 = (maxWidth-size)%g;
                    StringBuilder r = new StringBuilder(words[start]);
                    for (int j = start+1; j < i; j++) {
                        for (int k = 0; k <= v1; k++) {
                            r.append(' ');
                        }
                        if (v2 > 0) {
                            r.append(' ');
                            --v2;
                        }
                        r.append(words[j]);
                    }
                    res.add(r.toString());
                }
            }
        }
        return res;
    }
}

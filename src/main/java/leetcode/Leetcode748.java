package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/12/10 9:11
 */
public class Leetcode748 {
    public static void main(String[] args) {
        Leetcode748 body = new Leetcode748();
        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};

        int[] a = {1,2,3};
        int[] b = a.clone();
        String s = body.shortestCompletingWord(licensePlate, words);
        System.out.println(s);

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int l = 0;
        int[] arr = new int[26];
        for (char c:licensePlate.toCharArray()) {
            if(c>='A' && c <= 'Z') {
                ++arr[(int)c-(int)'A'];
                ++l;
            }else if(c>='a' && c <= 'z') {
                ++arr[(int)c-(int)'a'];
                ++l;
            }
        }
        List<String>[] lists = new List[16];
        for (int i = l; i <= 15 ; i++) {
            lists[i] = new ArrayList<>();
        }
        for (String w:words) {
            if(w.length() >= l) {
                lists[w.length()].add(w);
            }
        }

        for (int i = l; i <= 15 ; i++) {
            for (String s:lists[i]) {
                System.out.println(s);
                int[] a = arr.clone();
                for (char c:s.toCharArray()) {
                    --a[c-'a'];
                }
                boolean flag = true;
                for (int j = 0; j < 26; j++) {
                    if(a[j] > 0){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return s;
                }
            }
        }
        return null;
    }

}

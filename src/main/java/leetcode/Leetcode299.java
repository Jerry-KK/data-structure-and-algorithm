package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author koujn
 * @date 2021/11/8 10:08
 */
public class Leetcode299 {

    public String getHint(String secret, String guess) {
        char[] srr = secret.toCharArray();
        char[] grr = guess.toCharArray();
        int[] arr = new int[srr.length];
        Map<Integer,Integer> map = new HashMap<>();
        int a,b;
        a = b = 0;
        for (int i = 0; i < srr.length; i++) {
            if(srr[i] == grr[i]){
                arr[i] = 1;
                ++a;
            }else {
                map.put((int)srr[i],map.getOrDefault((int)srr[i],0) + 1);
            }
        }
        for (int i = 0; i < srr.length; i++) {
            if(arr[i] == 0) {
                Integer size = map.get((int)grr[i]);
                if(size != null && size > 0){
                    ++b;
                    map.put((int)grr[i],--size);
                }
            }
        }
        return a + "A" + b + "B";
    }

    public String getHint2(String secret, String guess) {
        char[] srr = secret.toCharArray();
        char[] grr = guess.toCharArray();
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int a,b;
        a = b = 0;
        for (int i = 0; i < srr.length; i++) {
            if(srr[i] == grr[i]){
                ++a;
            }else {
                map.put((int)srr[i],map.getOrDefault((int)srr[i],0) + 1);
                Integer size = map.get((int)grr[i]);
                if(size != null && size > 0){
                    ++b;
                    map.put((int)grr[i],--size);
                }else {
                    list.add((int) grr[i]);
                }
            }
        }
        for (int i:list) {
            Integer size = map.get(i);
            if(size != null && size > 0){
                ++b;
                map.put(i,--size);
            }
        }
        return a + "A" + b + "B";
    }

    public String getHint3(String secret, String guess) {
        int[] arr = new int[10];
        int[] brr = new int[10];
        int a,b;
        a = b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i))
                ++a;
            else {
                arr[secret.charAt(i) - '0']++;
                brr[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++)
            b += Math.min(arr[i],brr[i]);
        return a + "A" + b + "B";
    }

}

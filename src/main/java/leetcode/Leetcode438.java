package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2021/11/28 13:26
 */
public class Leetcode438 {

    public static void main(String[] args) {
        Leetcode438 body = new Leetcode438();
        List<Integer> anagrams2 = body.findAnagrams2("abab", "ab");
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++)
            ++arr[p.charAt(i)-'a'];
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            int[] a = arr.clone();
            boolean flag = true;
            for (int j = i; j < i+p.length(); j++) {
                int idx = s.charAt(j) - 'a';
                if(a[idx] == 0){
                    flag = false;
                    break;
                }else {
                    --a[idx];
                }
            }
            if(flag && allZero(a))
                res.add(i);
        }
        return res;
    }

    private boolean allZero(int[] arr) {
        for (int num:arr) {
            if(num != 0)
                return false;
        }
        return true;
    }

    //双指针
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length())
            return res;
        int[] arr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++arr[p.charAt(i) - 'a'];
            --arr[s.charAt(i) - 'a'];
        }
        if(allZero(arr))
            res.add(0);
        for (int i = 1; i < s.length()-p.length()+1; i++) {
            ++arr[s.charAt(i-1) - 'a'];
            --arr[s.charAt(i+p.length()-1) - 'a'];
            if(allZero(arr))
                res.add(i);
        }
        return res;
    }

}

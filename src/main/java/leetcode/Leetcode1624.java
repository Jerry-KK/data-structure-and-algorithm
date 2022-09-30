package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2022/9/17 18:26
 */
public class Leetcode1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int r = -1;
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if(arr[idx] == -1)
                arr[idx] = i;
            else
                r = Math.max(r, i - arr[idx] - 1);
        }
        return r;
    }

    public int maxLengthBetweenEqualCharacters2(String s) {
        int r = -1, idx;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            idx = s.charAt(i) - 'a';
            if(arr[idx] == 0)
                arr[idx] = i + 1;
            else
                r = Math.max(r, i - arr[idx]);
        }
        return r;
    }

    public int maxLengthBetweenEqualCharacters3(String s) {
        int r = -1;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            if(arr[s.charAt(i) - 'a'] != 0 || (arr[s.charAt(i) - 'a'] = i + 1) > 0 )
                r = Math.max(r, i - arr[s.charAt(i) - 'a']);
        return r;
    }

    public int maxLengthBetweenEqualCharacters4(String s) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1};
        for (int i = 0; i < s.length(); i++)
            if(arr[s.charAt(i) - 'a'] != 0 || (arr[s.charAt(i) - 'a'] = i + 1) > 0 )
                arr[26] = Math.max(arr[26], i - arr[s.charAt(i) - 'a']);
        return arr[26];
    }

}

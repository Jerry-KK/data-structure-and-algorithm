package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koujn
 * @date 2021/11/6 14:34
 */
public class Leetcode1218 {

    public static void main(String[] args) {
        int[] a = {16,-4,-6,-11,-8,-9,4,-11,15,15,-9,11,7,-7,10,-16,4};
        Leetcode1218 body = new Leetcode1218();
        int i = body.longestSubsequence2(a, 3);
        System.out.println(i);
    }

    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        int n = arr.length;
        int[] brr = new int[n];
        for (int i = 0; i < n - max; ++i) {
            if(brr[i] == 1)
                continue;
            int l = 1;
            int v = arr[i] + difference;
            brr[i] = 1;
            for (int j = i + 1 ; j < n && l + n - j > max ; j++) {
                if(brr[i] == 1)
                    continue;
                if(arr[j] == v) {
                    ++l;
                    v+=difference;
                    brr[j] = 1;
                }
            }
            if(l > max)
                max = l;
        }
        return max;
    }

    public int longestSubsequence2(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for (int a:arr) {
            if(map.get(a-difference) == null)
                map.put(a,1);
            else {
                int n = map.get(a-difference) + 1;
                map.put(a,n);
                if(n > max)
                    max = n;
            }
        }
        return max;
    }

    public int longestSubsequence3(int[] arr, int difference) {
        Map<Integer,Integer> dp = new HashMap<>();
        int ans = 1;
        for (int v:arr) {
            dp.put(v,dp.getOrDefault(v - difference,0) + 1);
            ans = Math.max(ans,dp.get(v));
        }
        return ans;
    }
    
}

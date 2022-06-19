package leetcode;

/**
 * @author lethe
 * @date 2022/3/8 12:11
 */
public class Leetcode2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        int l = s.length();
        int[] arr = new int[l];
        int[] left = new int[l];
        int[] right = new int[l];
        for (int i = 0,v = 0; i < l; i++) {
            if(s.charAt(i) == '*') {
                ++v;
            }else {
                arr[i] = v;
            }
        }
        for (int i = 0,v = -1; i < l; i++) {
            if(s.charAt(i) == '|') {
                v = i;
            }
            left[i] = v;
        }
        for (int i = l-1,v = -1; i >= 0; --i) {
            if(s.charAt(i) == '|') {
                v = i;
            }
            right[i] = v;
        }
        for (int i = 0; i < queries.length; i++) {
            int x = right[queries[i][0]];
            int y = left[queries[i][1]];
            answer[i] = x < 0 || y < 0 || x > y ? 0 : arr[y]-arr[x];
        }
        return answer;
    }

}

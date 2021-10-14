package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/9/16 9:11
 */
public class Leetcode212 {
    public static void main(String[] args) {
        Leetcode212 body = new Leetcode212();

    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        int l = words.length;
        List<String> res = new ArrayList<>();
        int[] flagArr = new int[l];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < l; k++) {
                    if(flagArr[k] == 1)
                        continue;

                }
            }
        }
        return null;
    }


}

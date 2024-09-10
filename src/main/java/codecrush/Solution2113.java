package codecrush;

import java.util.List;

public class Solution2113 {

    public char determineChess(List<String> board, int n) {
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board.get(i).charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 'E' && helper(i, j, arr)) {
                    return arr[i][j];
                }
            }

        }
        return 'E';
    }

    private boolean helper(int x, int y, char[][] arr) {
        char v = arr[x][y];
        int count = 1;
        for (int i = 1; i < 5 && x + i < arr.length; i++,++count) {
            if(arr[x + i][y] != v) {
                break;
            }
        }
        if (count == 5)
            return true;

        count = 1;
        for (int i = 1; i < 5 && y + i < arr[0].length; i++,++count) {
            if(arr[x][y+i] != v) {
                break;
            }
        }
        if (count == 5) {
            return true;
        }

        count = 1;
        for (int i = 1; i < 5 && x + i < arr.length && y + i < arr[0].length; i++,++count) {
            if(arr[x+i][y+i] != v) {
                break;
            }
        }
        if (count == 5) {
            return true;
        }

        count = 1;
        for (int i = 1; i < 5 && x + i < arr.length && y - i >= 0; i++,++count) {
            if(arr[x+i][y-i] != v) {
                break;
            }
        }
        if (count == 5) {
            return true;
        }
        return false;
    }

}

package leetcode;

/**
 * @author lethe
 * @date 2021/12/18 13:14
 */
public class Leetcode419 {

    public int countBattleships(char[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(i > 0 && board[i-1][j] == 'X') continue;
                if(j > 0 && board[i][j-1] == 'X') continue;
                if(board[i][j] == 'X') ++sum;
            }
        }
        return sum;
    }

}

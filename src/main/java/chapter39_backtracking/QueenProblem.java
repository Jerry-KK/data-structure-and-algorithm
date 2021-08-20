package chapter39_backtracking;

import org.w3c.dom.ls.LSOutput;

/**
 * @author koujn
 * @date 2021/8/16 9:44
 */
public class QueenProblem {
    public static void main(String[] args) {
        cal8queens(0);
    }

    //全局或成员变量,下标表示行，值表示queen存储在哪一列
    static int[] result = new int[8];

    //调用方式:cal8queens(0)
    public static void cal8queens(int row) {
        if(row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if(isOk(row, column)) {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftup = column -1, rightup = column + 1;
        for (int i = row-1; i >= 0 ; --i) {
            if(result[i] == column) return false;
            if(leftup >= 0 && result[i] == leftup) return false;
            if(rightup < 8 && result[i] == rightup) return false;
            --leftup;
            ++rightup;
        }
        return true;
    }

    // 打印出一个二维矩阵
    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if(result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

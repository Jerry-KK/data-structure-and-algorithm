package chapter40_dynamic_programming;

/**
 * “杨辉三角”不知道你听说过吗？我们现在对它进行一些改造。
 * 每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。
 * 请你编程求出从最高层移动到最底层的最短路径长度。
 *                  5
 *              7       8
 *          2       3       4
 *      4       9       6       1
 *  2       7       9       4       5
 * @author lethe
 * @date 2021/8/16 20:12
 */
public class Triangle {
    public static void main(String[] args) {
        test();
    }

    private static void test() {

        int[] triangle = {0, 5, 7, 8, 2, 3, 4, 4, 9, 6, 1, 2, 7, 9, 4, 5};
        int line = 5;
        int[][] status = new int[line][line];
        status[0][0] = triangle[1];
        for (int i = 0,index = 0; i < line - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int leftVal = status[i][j] + triangle[index  + j + i + 2];
                if(status[i+1][j] == 0 ) {
                    status[i+1][j] = leftVal;
                }else {
                    if(leftVal < status[i+1][j])
                        status[i+1][j] = leftVal;
                }
                int rightVal = status[i][j] + triangle[index + i + j + 3];
                if(status[i+1][j+1] == 0 ) {
                    status[i+1][j+1] = rightVal;
                }else {
                    if(rightVal < status[i+1][j+1])
                        status[i+1][j+1] = leftVal;
                }
            }
            index+=i+1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < line; i++) {
            if(status[line-1][i] < ans)
                ans = status[line-1][i];
        }
        System.out.println(ans);
    }
}

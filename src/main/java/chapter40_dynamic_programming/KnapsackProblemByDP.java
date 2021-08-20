package chapter40_dynamic_programming;

/**
 * @author koujn
 * @date 2021/8/16 15:01
 */
public class KnapsackProblemByDP {

    public static void main(String[] args) {
        int[] items = {2,2,4,6,1};
        System.out.println(knapsack(items,5,9));
    }

    /**
     * @param items    物品重量
     * @param n         物品个数
     * @param w         背包可承受重量
     */
    public static int knapsack(int[] items, int n, int w){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(items[0] <= w)
            states[0][items[0]] = true;
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j <= w ; j++) {
                if(states[i-1][j] == true)
                    states[i][j] = true;
            }
            for (int j = 0; j <= w - items[i]; j++) {
                if(states[i-1][j] == true)
                    states[i][j+items[i]] = true;
            }
        }
        for (int k = w; k >= 0 ; --k) {
            if(states[n-1][k] == true) {
                return k;
            }
        }
        return 0;
    }

    //改用1维数组
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] status = new boolean[w+1];
        status[0] = true;
        if(items[0] <= w)
            status[items[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w - items[i]; j++) {
                if(status[j] == true)
                    status[j+items[i]] = true;
            }
        }
        for (int k = w; k >= 0 ; --k) {
            if(status[k] == true)
                return k;
        }
        return 0;
    }

    //0-1 背包问题升级版
    //增加价值
}

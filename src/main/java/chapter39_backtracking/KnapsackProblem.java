package chapter39_backtracking;

/**
 * 0-1's Knapsack Problem
 * @author koujn
 * @date 2021/8/16 14:02
 */
public class KnapsackProblem {

    /** 存储背包中物品重量的最大值 */
    private static int maxW = Integer.MIN_VALUE;

    /**
     * @param i     表示靠擦到哪个物品了
     * @param cw    表示当前已经装进去的物品的重量和
     * @param items 表示每个物品的重量
     * @param n     表示物品的个数
     * @param w     表示背包重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if(cw == w || i == n) {
            if(cw > maxW) maxW = cw;
            return;
        }
        f(i+1,cw,items,n,w);
        if(cw + items[i+1] <= w) {
            f(i+1,cw+items[i+1],items,n,w);
        }
    }

}

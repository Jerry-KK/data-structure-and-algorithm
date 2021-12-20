package leetcode;

/**
 * @author koujn
 * @date 2021/12/17 16:18
 */
public class Leetcode1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while (numBottles >= numExchange) {
            int i = numBottles / numExchange;
            int j = numBottles % numExchange;
            sum += i;
            numBottles = i+j;
        }
        return sum;
    }
}

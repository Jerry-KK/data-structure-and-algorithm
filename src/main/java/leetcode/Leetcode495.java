package leetcode;

/**
 * @author koujn
 * @date 2021/11/10 10:19
 */
public class Leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        int sum = 0;
        for (int i = 1; i < timeSeries.length ; ++i)
            sum += Math.min(duration,timeSeries[i] - timeSeries[i-1]);
        return sum+duration;
    }
}

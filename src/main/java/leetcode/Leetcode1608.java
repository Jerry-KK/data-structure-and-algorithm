package leetcode;

/**
 * @author lethe
 * @date 2022/9/12 22:28
 */
public class Leetcode1608 {

    public int specialArray(int[] nums) {
        int[] arr = new int[1001];
        for (int n : nums)
            arr[n]++;
        for (int i = 102; i <= 1000 ; ++i)
            arr[101] += arr[i];
        for (int i = 100; i >= 0; --i)
            if((arr[i] += arr[i+1]) == i)
                return i;
        return -1;
    }

    public int specialArray2(int[] nums) {
        int[] arr = new int[1001];
        for (int n : nums)
            arr[n]++;
        int sum = 0;
        for (int i = 101; i <= 1000 ; ++i)
            sum += arr[i];
        for (int i = 100; i >= 0; --i)
            if((sum += arr[i]) == i)
                return i;
        return -1;
    }

}

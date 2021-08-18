package chapter42_dynamic_programming;

/**
 * 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？
 * 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
 * @author lethe
 * @date 2021/8/17 21:53
 */
public class TestDemo {

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 6, 5, 1, 7};
        System.out.println(getMaxLength(arr,7));
    }

    private static int getMaxLength(int[] arr, int n) {
        int[] status = new int[n];
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    int size = status[i] + 1;
                    if(size > status[j]) status[j] = size;
                }
            }
        }
        //初始status为0，只有一个字符时长度也为1，所以最终结果要加1
        for (int k = n-1 ; k >= 0 ; --k) {
            if (status[k] != 0)
                return status[k] + 1;
        }
        return 1;
    }





}

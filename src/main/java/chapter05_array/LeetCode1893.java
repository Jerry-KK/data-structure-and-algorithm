package chapter05_array;

/**
 * @author koujn
 * @date 2021/7/23 9:50
 */
public class LeetCode1893 {
    public static void main(String[] args) {
        int[][] ranges = {{1,2},{3,4},{5,6}};
        System.out.println(isCovered(ranges, 1, 6));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[right - left + 1];
        for (int i = 0; i < ranges.length; i++) {
            if(ranges[i][0] <= right || ranges[i][1] >= left) {
                int end = ranges[i][1] < right  ? ranges[i][1] - left : right - left;
                for (int j = ranges[i][0] > left ? ranges[i][0] - left : 0; j <= end; j++) {
                    arr[j] = 1;
                }
            }
        }
        for (int i = 0 ; i < arr.length; i++) {
            if(arr[i] == 0) {
                return false;
            }
        }
        return true;
    }

    //标准答案，差分数组
    public static boolean isCovered2(int[][] ranges, int left, int right) {
        int[] diff  = new int[52];
        for (int[] arr:ranges) {
            ++diff[arr[0]];
            --diff[arr[1]+1];
        }
        int sum = 0;
        for (int i = 0; i < 52; i++) {
            sum += diff[i];
            if(i >= left && i <= right && sum <= 0) {
                return false;
            }
        }
        return true;
    }
}

package leetcode.efficientwinning;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2022/3/5 13:53
 */
public class Leetcode167 {

    public static void main(String[] args) {
        Leetcode167 body = new Leetcode167();
        int[] numbers = {2,7};
        int[] ints = body.twoSum(numbers, 9);
        System.out.println(ints[0] + " , " + ints[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2001];
        int[] ans = new int[2];
        Arrays.fill(arr,-1);
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            if(val >= -1000 && val <= 1000 && arr[val+1000] != -1) {
                ans[0] = arr[val+1000];
                ans[1] = i;
                break;
            }else {
                arr[numbers[i]+1000] = i;
            }
        }
        return ans;
    }

    //双指针
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if(numbers[i] + numbers[j] > target) {
                --j;
            }else if(numbers[i] + numbers[j] < target) {
                ++i;
            }
        }
        return new int[]{i,j};
    }
}

package chapter11_sorts;

/**
 * @author koujn
 * @date 2021/7/28 15:30
 */
public class Leetcode167 {
    public static void main(String[] args) {
        int[] arr = {1,4,8,9,12};
        int[] res = twoSum3(arr,12);
        System.out.println(res[0] + ":"+res[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > target/2) {
                break;
            }
            int val = target - numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[j] == val) {
                    res[0] = i+1;
                    res[1] = j+1;
                    return res;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int n = -1;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > target/2) {
                break;
            }
            int val = target - numbers[i];
            int low = i+1;
            int high = numbers.length-1;
            while (low < high) {
                int mid = low+(high-low)>>1;
                if(numbers[mid] > val) {
                    if(numbers[mid-1] < val){
                        break;
                    }
                    high = mid-1;
                } else if(numbers[mid] < val){
                    if(numbers[mid+1] > val){
                        break;
                    }
                    low = mid+1;
                } else {
                    n = mid + 1;
                    break;
                }
            }
            if(n != -1) {
                res[0] = i+1;
                res[1] = n;
                return res;
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}

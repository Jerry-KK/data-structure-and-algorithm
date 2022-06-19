package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/24 16:16
 */
public class Demo {
    public static void main(String[] args) {
        Demo body = new Demo();
        int[] arr = {1,1,2};
        body.helper(arr);
        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        body.helper(arr2);

    }
    public void helper(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int x = arr[0];
        sb.append('[').append(x);
        for (int k = 1; k < arr.length; k++) {
            if(arr[k] != x) {
                x = arr[k];
                sb.append(',').append(x);
            }
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}

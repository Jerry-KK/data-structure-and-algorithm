package leetcode;

/**
 * @author lethe
 * @date 2022/2/25 11:05
 */
public class Leetcode537 {

    public String complexNumberMultiply(String num1, String num2) {
        int[] arr1 = helper(num1);
        int[] arr2 = helper(num2);
        StringBuilder sb = new StringBuilder();
        sb.append(arr1[0] * arr2[0] - arr1[1]* arr2[1])
                .append("+")
                .append(arr1[0] * arr2[1] + arr1[1]* arr2[0])
                .append('i');
        return sb.toString();
    }

    public int[] helper(String s) {
        int[] arr = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+') {
                arr[0] = Integer.parseInt(s.substring(0,i));
                arr[1] = Integer.parseInt(s.substring(i+1,s.length()-1));
            }
        }
        return arr;
    }

}

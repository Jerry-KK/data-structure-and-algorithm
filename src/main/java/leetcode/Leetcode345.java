package leetcode;

/**
 * @author koujn
 * @date 2021/8/19 13:54
 */
public class Leetcode345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        int index = "aeiouAEIOU".indexOf('a');
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        boolean[] ascii = new boolean[256];
        ascii['a'] = true;
        ascii['A'] = true;
        ascii['e'] = true;
        ascii['E'] = true;
        ascii['i'] = true;
        ascii['I'] = true;
        ascii['o'] = true;
        ascii['O'] = true;
        ascii['u'] = true;
        ascii['U'] = true;
        int i = 0,j=arr.length-1;
        while (i < j) {
            while (i < j && !ascii[arr[i]]) {
                i++;
            }
            while (j > i && !ascii[arr[j]]) {
                j--;
            }
            if(i != j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
                --j;
            }
        }
        return String.valueOf(arr);
    }
}

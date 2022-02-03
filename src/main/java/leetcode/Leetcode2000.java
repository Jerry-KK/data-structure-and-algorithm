package leetcode;

/**
 * @author lethe
 * @date 2022/2/2 12:37
 */
public class Leetcode2000 {

    public String reversePrefix(String word, char ch) {
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == ch) {
                for (int j = 0; j < i; j++,i--) {
                    char temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                break;
            }
        }
        return String.valueOf(array);
    }
}

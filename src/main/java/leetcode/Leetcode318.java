package leetcode;

/**
 * @author lethe
 * @date 2021/11/17 0:08
 */
public class Leetcode318 {

    public static void main(String[] args) {
        Leetcode318 body = new Leetcode318();
        String[] words = {"a","aa","aaa"};
        int i = body.maxProduct(words);
        System.out.println(i);
    }

    public int maxProduct(String[] words) {
        int max = 0;
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int x = 0;
            for (char c: words[i].toCharArray()) {
                if((x & (1<< ( c-'a'))) == 0 )
                    x += 1<< ( c-'a');
            }
            arr[i] = x;
        }
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((arr[i] & arr[j]) == 0)
                    max = Math.max(max,words[i].length() * words[j].length());
            }
        }
        return max;
    }
}

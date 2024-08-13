package codecrush;

public class Solution2105 {

    public static void main(String[] args) {
        Solution2105 body = new Solution2105();
        System.out.println(body.zip("aabcccccaaa"));
        System.out.println(body.zip("abbccd"));
    }

    public String zip(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char last = arr[0];
        int n = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == last) {
                ++n;
            } else {
                sb.append(last).append(n);
                last = arr[i];
                n = 1;
            }
        }
        sb.append(last).append(n);
        String res = sb.toString();
        return res.length() < str.length() ? res : str;
    }

}

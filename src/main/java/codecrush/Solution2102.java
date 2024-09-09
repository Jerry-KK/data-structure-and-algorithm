package codecrush;

public class Solution2102 {

    public static void main(String[] args) {
        Solution2102 body = new Solution2102();
        System.out.println(body.atoi("134"));
        System.out.println(body.atoi("  -134"));
        System.out.println(body.atoi("234abc234"));
        System.out.println(body.atoi("      "));
    }

    public int atoi(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        for (; i < arr.length && arr[i] == ' '; i++);
        boolean flag = true;
        if (i == arr.length)
            return 0;
        if (arr[i] == '+' || arr[i] == '-') {
            flag = arr[i] == '+';
            ++i;
        }
        int res = 0;
        for(; i < arr.length && arr[i] >= '0' && arr[i] <= '9'; ++i)
            res = res * 10 + (arr[i] - '0');
        return flag ? res : -res;
    }

}

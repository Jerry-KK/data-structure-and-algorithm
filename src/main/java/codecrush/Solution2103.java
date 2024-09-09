package codecrush;

public class Solution2103 {

    public static void main(String[] args) {
        Solution2103 body = new Solution2103();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
//        System.out.println(body.atoi("134"));
//        System.out.println(body.atoi("  -134"));
//        System.out.println(body.atoi("234abc234"));
//        System.out.println(body.atoi("      "));
        System.out.println("------------");
        System.out.println(body.atoi2(" -2147483648"));
//        System.out.println(body.atoi2(String.valueOf(Integer.MAX_VALUE)));
    }

    public int atoi(String s) {
        char[] arr = s.toCharArray();
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
        if (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
            res = flag ? arr[i] - '0' : '0' - arr[i];
            ++i;
        }
        for(; i < arr.length && arr[i] >= '0' && arr[i] <= '9'; ++i) {
            if (flag) {
               res = res * 10 - '0'  + arr[i];
               if (res < 0) {
                   return 0;
               }
            } else {
                res = res * 10 +  '0'  - arr[i];
                if (res > 0) {
                    return 0;
                }
            }
        }
        return res;
    }

    public int atoi2(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        boolean sign = false;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-';
            i++;
        }
        int ans = 0;
        int maxV = Integer.MAX_VALUE / 10;
        for (; i < n && Character.isDigit(s.charAt(i)); i++) {
            int v = s.charAt(i) - '0';
            if (ans > maxV || ans == maxV && (!sign && v > 7 || sign && v > 8)) {
                return 0;
            }
            ans = ans * 10 + v;
        }
        if (sign) {
            return -ans;
        }
        return ans;
    }



}

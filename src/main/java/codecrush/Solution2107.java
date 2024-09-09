package codecrush;

import java.util.Stack;

public class Solution2107 {

    public static void main(String[] args) {
        Solution2107 body = new Solution2107();
        System.out.println(body.formatInteger(1234567891));
        System.out.println("十二亿三千四百五十六万七千八百九十一");
        System.out.println(body.formatInteger(100));
        System.out.println("一百");
        System.out.println(body.formatInteger(1000000001));
        System.out.println("十亿零一");
        System.out.println(body.formatInteger(1010));
        System.out.println("一千零一十");
        System.out.println(body.formatInteger(10010));
        System.out.println("一万零一十");
    }

    private static final String[] arr = {"", "万", "亿", "兆"};
    private static final String[] arr2 = {"", "十", "百", "千"};
    private static final String[] arr3 ={"", "一","二","三","四","五","六","七","八","九"};
    private static final String ZERO = "零";

    public String formatInteger(int num) {
        if(num == 0)
            return ZERO;
        Stack<String> stack = new Stack<>();
        for (int i = 0; num > 0 ; ++i, num /= 10000) {
            if(num%10000 == 0)
                continue;
            stack.add(arr[i]);
            stack.add(helper(num % 10000));
            if(num%10000 < 1000)
                stack.add(ZERO);
        }
        String res = stackToStr(stack);
//        if (res.length() > 1 && res.charAt(1) == '十' && res.charAt(0) == '一')        //特殊处理"一十"开头
//            return res.substring(1);
        if(res.startsWith("一十"))                                                    //特殊处理"一十"开头
            return res.substring(1);
        return res;
    }

    private String helper(int num) {
        int[] values = new int[4];
        for (int i = 0; num>0; i++) {
            values[i] = num%10;
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 4;
        if (values[3] > 0) {                                    //处理千位
            sb.append(arr3[values[3]]).append(arr2[3]);
            idx = 3;
        }
        if (values[2] > 0) {                                    //处理百位
            sb.append(arr3[values[2]]).append(arr2[2]);
            idx = 2;
        }
        if (values[1] > 0) {                                    //处理十位
            if(idx == 3) {
                sb.append(ZERO);
            }
            sb.append(arr3[values[1]]).append(arr2[1]);
            idx = 1;
        }
        if (values[0] > 0) {                                    //处理十位
            if(idx == 3 || idx == 2) {
                sb.append(ZERO);
            }
            sb.append(arr3[values[0]]);
        }
        return sb.toString();
    }

    private String stackToStr(Stack<String> stack) {
        while (!stack.isEmpty() && stack.peek().equals(ZERO))
            stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }


}

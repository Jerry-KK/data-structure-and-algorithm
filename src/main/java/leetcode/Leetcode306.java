package leetcode;

/**
 * @author lethe
 * @date 2022/1/10 14:17
 */
public class Leetcode306 {

    public static void main(String[] args) {
        Leetcode306 body = new Leetcode306();
        boolean res = body.isAdditiveNumber("198019823962");
        System.out.println(res);
    }

    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length()-2; i++) {
            if(i > 0 && num.charAt(0) == '0')
                break;
            long first = Long.parseLong(num.substring(0,i+1));
            for (int j = i+1; j < num.length()-1; j++) {
                if(j>i+1 && num.charAt(i+1) == '0')
                    break;
                long second = Long.parseLong(num.substring(i+1,j+1));
                long a = first,b = second;
                for (int k = j+1; ;) {
                    long c = a + b;
                    String s = String.valueOf(c);
                    boolean flag = false;
                    if(s.length() > num.length() - k)
                        break;
                    for (int l = 0; l < s.length() && k < num.length(); l++) {
                        if (num.charAt(k++) != s.charAt(l)) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                    if(k == num.length())
                            return true;
                    a = b;
                    b = c;
                }
            }
        }
        return false;
    }

}

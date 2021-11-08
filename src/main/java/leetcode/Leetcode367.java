package leetcode;

/**
 * @author koujn
 * @date 2021/11/6 11:17
 */
public class Leetcode367 {

    public static void main(String[] args) {
        Leetcode367 body = new Leetcode367();
        boolean res = body.isPerfectSquare(2147395600);
        System.out.println(res);
    }

    public boolean isPerfectSquare(int num) {
        int sqrt = (int)Math.sqrt(num);
        if(sqrt * sqrt == num)
            return true;
        else
            return false;
    }

    //不适用sqrt方法
    /**
     * num = n * n = 1 + 3 + 5 + ... + ( 2 * n + 1 )
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int x = 1;
        while (num > 0) {
            num -= x;
            x +=2;
        }
        return num == 0;
    }

}

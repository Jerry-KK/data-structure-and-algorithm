package leetcode;

/**
 * @author lethe
 * @date 2021/12/31 23:09
 */
public class Leetcode507 {

    public static void main(String[] args) {
        Leetcode507 body = new Leetcode507();
        boolean res = body.checkPerfectNumber(6);
        System.out.println(res);
    }

    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int sum = 0;
        int i = 1;
        int j = num;
        while (i < j) {
            if(num%i == 0) {
                sum += (i+j);
            }
            ++i;
            j = num/i;
        }
        sum-=num;
        return sum == num;
    }

}

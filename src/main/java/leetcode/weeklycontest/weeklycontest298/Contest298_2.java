package leetcode.weeklycontest.weeklycontest298;

/**
 * @author lethe
 * @date 2022/6/19 10:22
 */

/**
 *  个位数字为 K 的整数之和
 *  0:18:34  1次错误尝试
 */
public class Contest298_2 {

    public static void main(String[] args) {
        int res = minimumNumbers(58,9);
        System.out.println(res);
    }

    public static int minimumNumbers(int num, int k) {
        if(num == 0)
            return 0;
        int a = num % 10;
        for (int i = 1; i <= 10; i++)
            if(k * i % 10 == a)
                if( k * i <= num)
                    return i;
        return -1;
    }

}

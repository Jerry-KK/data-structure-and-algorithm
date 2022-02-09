package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/2/10 0:07
 */
public class Leetcode1447 {

    public static void main(String[] args) {
        Leetcode1447 body = new Leetcode1447();
        List<String> list = body.simplifiedFractions(4);
        list.forEach(System.out::println);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++)
                if (gcd(j,i) == 1)
                    list.add(j + "/" + i);
        }
        return list;
    }

    private int gcd(int a,int b) {
        return b != 0 ? gcd(b,a%b) : a;
    }

}

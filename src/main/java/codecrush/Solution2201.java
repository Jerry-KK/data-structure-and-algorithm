package codecrush;

public class Solution2201 {

    public static void main(String[] args) {
        System.out.println(drink(13));
    }

    public static int drink(int n) {
        int a = n, b = n, res = n;
        while (a >= 3 || b >= 5) {
            n = a/3 + b/5;
            res += n;
            a = a%3 + n;
            b = b%5 + n;
        }
        return res;
    }

}

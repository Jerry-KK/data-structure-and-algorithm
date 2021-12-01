package leetcode;

/**
 * @author koujn
 * @date 2021/11/30 9:23
 */
//todo
public class Leetcode400 {
    public static void main(String[] args) {
        Leetcode400 body = new Leetcode400();
        int nthDigit = body.findNthDigit2(1000000000);
        System.out.println(nthDigit);
    }

    public int findNthDigit(int n) {
        if(n <= 9)
            return n;
        int s = 9;
        int w = 2;
        n-=9;
        int end = 9* 10^(w-1) * w;
        while (n > end) {
            n -= end;
            s = end;
            ++w;
            end = 9* 10^(w-1) * w;
        }
        int c = n / w;
        int y = n % w;
        if(y == 0) {
            return (s+c)%10;
        }else {
            return (s+c+1)%(10^(w-y))&1;
        }
    }

    public int findNthDigit2(int n) {
        int w = 1;
        long s = 1 *(int)Math.pow(10,w-1);
        int k = 9 *(int)Math.pow(10,w-1) *w;
        while (n > k) {
            n-=k;
            ++w;
            k = 9 * (int)Math.pow(10,w-1) *w;
            s = 1 * (int)Math.pow(10,w-1);
        }
        long c = n / w;
        int y = n % w;
        if(y == 0) {
            return (int)(s+c-1)%10;
        }else {
            return (int)((s+c)/((int)Math.pow(10,w-y)))%10;
        }
    }
}

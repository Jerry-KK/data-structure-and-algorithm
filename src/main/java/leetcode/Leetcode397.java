package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koujn
 * @date 2021/11/19 9:17
 */
//todo
public class Leetcode397 {

    public static void main(String[] args) {
        Leetcode397 body = new Leetcode397();
        int i = body.integerReplacement2(100000000);
        System.out.println(i);
    }



    public int integerReplacement(int n) {
        if(n < 2)
            return 0;
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            if((i&1) == 0) {
                dp[i] = dp[i>>1]+1;
            }else {
                dp[i] = Math.min(dp[(i-1)>>1],dp[(i+1)>>1])+2;
            }
        }
        return dp[n];
    }

    private Map<Integer,Integer> map;

    public int integerReplacement2(int n) {
        if(n < 2)
            return 0;
        map = new HashMap<>();
        map.put(2,1);
        test(n);
        return map.get(n);
    }

    public void test(int n){
        int sum = 0;
        while ((n&1) == 0) {
            n = n >> 1;
            ++sum;
        }
        if(map.get((n-1)>>1) == null) {
            test((n-1)>>1);
        }
        if(map.get((n+1)>>1) == null) {
            test((n+1)>>1);
        }

    }


    public int integerReplacement3(int n) {
        map = new HashMap<>();
        for (int i = 2,j = 1; i < n; i*=2) {
            map.put(i,j++);
        }
        return dg(n, 0);
    }

    public int dg(int n,int sum) {
        while (n != 1) {
            if((n&1)==0){
                ++sum;
                n = n>>1;
            }else {
                int n1 = map.get((n+1)>>1) == null ? dg((n+1)>>1,sum+2) : map.get((n+1)>>1);
                int n2 = map.get((n-1)>>1) == null ? dg((n-1)>>1,sum+2) : map.get((n-1)>>1);
                sum = Math.min(n1,n2);
                break;
            }
        }
        return sum;
    }

}

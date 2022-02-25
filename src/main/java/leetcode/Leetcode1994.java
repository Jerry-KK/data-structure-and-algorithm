package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/2/22 0:37
 */
public class Leetcode1994 {

    public static void main(String[] args) {
        Leetcode1994 body = new Leetcode1994();
        //int[] nums = {4,2,3,15};
//        int[] nums = {6,8,1,8,6,5,6,11,17};         //62
        int[] nums = {10,11,5,1,10,1,3,1,26,11,6,1,1,15,1,7,22,1,1,1,1,1,23,1,29,5,6,1,1,29,1,1,21,19,1,1,1,2,1,11,1,15,1,22,14,1,1,1,1,6,7,1,14,3,5,1,22,1,1,1,17,1,29,2,1,15,10,1,5,7,1,1,1,30,1,30,1,21,10,1,1,1,1,1,2,6,5,7,3,1,1,19,29,1,7,13,14,1,5,26,19,11,1,1,1,1,1,1,1,1,22,15,1,1,13,1,17,1,1,1,13,6,1,10,1,1,17,1,1,3,14,7,17,1,13,1,1,1,1,1,11,1,1,6,1,1,1,1,1,2,1,30,2,26,1,1,14,1,26,29,30,1,13,21,1,1,14,21,1,23,1,15,23,21,1,30,19,19,1,10,23,3,3,17,22,2,26,1,11,1,23,1,1,1,15,1,1,13,1,1};
        int i = body.numberOfGoodSubsets(nums);
        System.out.println(i);
    }

    static final int[] arr  = {2,3,5,7,11,13,17,19,23,29};


    public int numberOfGoodSubsets(int[] nums) {
        int[] res = {-1};
        long n1 = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if(num == 1) {
                ++n1;
            }else {
                int s = isNeed(num);
                if(s != 0) {
                    list.add(s);
                }
            }
        }
        helper(list,0,res);
        double pow = Math.pow(2, n1);
        pow %= 1000000007;
        return res[0] * (int)(pow) % 1000000007;
    }

    private int isNeed(int num) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > num) {
                break;
            }else if(num%arr[i] == 0){
                num /= arr[i];
                s|=(1<<i);
            }
        }
        return num == 1 ? s : 0;
    }

    //回溯,超时
    private void helper(LinkedList<Integer> list,int v,int[] res) {
            if(list.size() == 0) {
                res[0] = (res[0]+1)%1000000007;
            }else {
                Integer i = list.removeFirst();
                helper(list,v,res);
                if((i&v) == 0)
                    helper(list,v|i,res);
                list.addFirst(i);
            }
    }

    static final int[] PRIMES  = {2,3,5,7,11,13,17,19,23,29};
    static final int NUM_MAX = 30;
    static final int MOD = (int)1e9+7;

    public int numberOfGoodSubsets2(int[] nums) {
        int[] arr = new int[NUM_MAX+1];
        for (int num:nums) {
            ++arr[num];
        }
        int[] f = new int[1<<PRIMES.length-1];
        f[0] = (int)(Math.pow(2,arr[1]))%MOD;
        for (int i = 2; i <= NUM_MAX; i++) {
            if (arr[i] == 0)
                continue;
            int save = 0;
            boolean flag = false;
            for (int j = 0; j < PRIMES.length; j++) {
                int prime = PRIMES[j];
                if(i % (prime * prime) == 0) {
                    flag = true;
                    break;
                }
                if(i % prime == 0) {
                    save |= (1<<j);
                }
            }
            if(flag)
                continue;
            for (int mask = (1<<PRIMES.length) -1; mask >0 ; mask++) {
                if((mask & save) == save)
                    f[mask] = (int)((f[mask] + ((long) f[mask | save] * arr[i]))%MOD);
            }
        }
        int ans = 0;
        for (int mask = 1, maxMask = (1<<PRIMES.length); mask < maxMask; mask++) {
            ans = (ans + f[mask]) % MOD;
        }
        return ans;
    }

}

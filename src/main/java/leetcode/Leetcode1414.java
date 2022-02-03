package leetcode;

import java.util.ArrayList;

/**
 * @author lethe
 * @date 2022/2/3 22:20
 */
public class Leetcode1414 {

    public static void main(String[] args) {
        Leetcode1414 body = new Leetcode1414();
        int res = body.findMinFibonacciNumbers4(10);
        System.out.println(res);
    }

    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 1;
        while (b <= k) {
            int temp = a;
            a = b;
            b +=temp;
            list.add(a);
        }
        int l = list.size();
        int res = 1;
        k -= list.get(l-1);
        while (k > 0) {
            int v = findFistMinVal(list, k);
            ++res;
            k-=v;
        }
        return res;
    }

    public int findFistMinVal(ArrayList<Integer> list, int tar) {
        int s = 0;
        int e = list.size();
        while (s <= e) {
            int mid = s + ((e-s)>>1);
            if(list.get(mid) > tar) {
                e = mid-1;
            } else if(list.get(mid) < tar) {
                s = mid+1;
            } else {
                return tar;
            }
        }
        return list.get(e);
    }

    public int findMinFibonacciNumbers2(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        for (int i = 2; ; i++) {
            int v = list.get(i-1) + list.get(i-2);
            if(v <= k) {
                list.add(v);
            }else {
                break;
            }
        }
        int l = list.size();
        int res = 0;
        for (int i = l-1; i >= 0; --i) {
            if(list.get(i) <= k) {
                k-=list.get(i);
                ++res;
            }
        }
        return res;
    }

    public int findMinFibonacciNumbers3(int k) {
        int a = 1;
        int b = 1;
        while (b <= k) {
            int temp = a;
            a = b;
            b += temp;
        }
        int res = 0;
        while (k > 0) {
            if(k >= a) {
                k-=a;
                ++res;
            }
            int temp = a;
            a = b - a;
            b = temp;
        }
        return res;
    }

    public int findMinFibonacciNumbers4(int k) {
        int a = 1;
        int b = 1;
        while (b <= k) {
            b += a;
            a = b - a;
        }
        int res = 0;
        while (k > 0) {
            if(k >= a) {
                k-=a;
                ++res;
            }
            a = b - a;
            b -= a;
        }
        return res;
    }
}

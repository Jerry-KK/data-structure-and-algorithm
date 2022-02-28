package leetcode;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2022/2/28 13:06
 */
public class Leetcode1601 {
    public static void main(String[] args) {
        Leetcode1601 body = new Leetcode1601();
        int n = 5;
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int result = body.maximumRequests(n, requests);
        System.out.println(result);
    }

    //回溯+减枝
    public int maximumRequests(int n, int[][] requests) {
        int[] res = {0};
        int[] arr = new int[n];
        helper(requests,0,0,arr,res);
        return res[0];
    }

    private void helper(int[][] requests,int idx,int sum, int[] arr,int[] res) {
        if(idx == requests.length) {
            for (int e:arr)
                if(e != 0)
                    return;
            res[0] = Math.max(res[0],sum);
        }else if(requests.length-idx+sum > res[0]) {
            helper(requests,idx+1,sum,arr,res);
            --arr[requests[idx][0]];
            ++arr[requests[idx][1]];
            helper(requests,idx+1,sum+1,arr,res);
            ++arr[requests[idx][0]];
            --arr[requests[idx][1]];
        }
    }


    //二进制枚举写法
    public int maximumRequests2(int n, int[][] requests) {
        int ans = 0;
        int[] arr = new int[n];
        int l = requests.length;
        for (int i = 0; i < (1<<l); i++) {
            int count = Integer.bitCount(i);
            if(count <= ans) {
                continue;
            }
            Arrays.fill(arr,0);
            for (int j = 0; j < l; j++) {
                if((i & (1 << j)) != 0) {
                    --arr[requests[j][0]];
                    ++arr[requests[j][1]];
                }
            }
            boolean flag = true;
            for (int a:arr) {
                if(a != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans = count;
            }
        }
        return ans;
    }

}

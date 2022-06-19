package leetcode;


/**
 * @author lethe
 * @date 2022/6/9 22:50
 */
public class Leetcode473 {

    public static void main(String[] args) {
        Leetcode473 body = new Leetcode473();
        int[] arr = {3,3,3,3,4};
        System.out.println(body.makesquare(arr));
    }

    boolean flag;
    int tar;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m:matchsticks) {
            sum += m;
        }
        if(sum%4!=0)
            return false;
        tar = sum/4;
        flag = true;
        helper(matchsticks,new int[matchsticks.length],tar,0,matchsticks.length-1,0);
        return !flag;
    }

    private void helper(int[] arr, int[] brr, int t,int idx,int l,int n) {
        if(idx == l || t == 0 ) {
            if(t == 0) {
                if(++n == 3) {
                    flag = false;
                }
                helper(arr,brr,tar,0,l,n);
            }
        } else if(flag) {
            for (int i = idx + 1; i <= l; i++) {
                if(brr[i] == 0 && t >= arr[i]) {
                    brr[i] = 1;
                    helper(arr,brr,t - arr[i],i,l,n);
                    brr[i] = 0;
                }
            }
        }
    }

}

package leetcode;

/**
 * @author lethe
 * @date 2021/12/19 11:45
 */
public class Leetcode997 {

    public static void main(String[] args) {
        Leetcode997 body = new Leetcode997();
//        int[][] trust = {{1,2}};
//        int judge = body.findJudge(2, trust);
        int[][] trust = {};
        int judge = body.findJudge(1, trust);
        System.out.println(judge);
    }

    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        int[][] arr2 = new int[n][n];
        for (int[] ints : trust) {
            arr[ints[0] - 1] = 1;
            arr2[ints[0] - 1][ints[1] - 1] = 1;
        }
        int size = 0;
        int idx  = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                idx = i;
                ++size;
            }
        }
        if(size != 1)
            return -1;
        arr2[idx][idx] = 1;
        for (int i = 0; i < n; i++)
            if(arr2[i][idx] != 1)
                return -1;
        return idx+1;
    }

}

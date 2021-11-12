package leetcode;


import java.util.LinkedList;

/**
 * @author koujn
 * @date 2021/11/10 10:57
 */
public class LeetcodeLCP07 {


    public static void main(String[] args) {
        LeetcodeLCP07 body = new LeetcodeLCP07();
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int i = body.numWays(5, relation, 3);
        System.out.println(i);
    }


    public int numWays(int n, int[][] relation, int k) {

        LinkedList<Integer>[] lists = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<>();
        }
        for (int[] ints : relation)
            lists[ints[0]].add(ints[1]);

        int[][] a = new int[k+1][n];
        a[0][0] = 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] > 0 ) {
                    for(int x:lists[j])
                        a[i+1][x]+=a[i][j];
                }
            }
        }
        return a[k][n-1];
    }

}

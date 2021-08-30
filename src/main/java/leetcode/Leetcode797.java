package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author koujn
 * @date 2021/8/25 14:43
 */
public class Leetcode797 {
    public static void main(String[] args) {

        //[[4,3,1],[3,2,4],[3],[4],[]]
        //int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        allPathsSourceTarget(graph);
        System.out.println(1);
    }



    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        test(0,new int[graph.length],graph,res);
        return res;
    }

    public static void test(int n,int[] arr,int[][] graph,List<List<Integer>> res){
        int a = arr[n];
        if(a == graph.length-1) {
            ArrayList list = new ArrayList();
            for (int i = 0; i <= n; i++) {
                list.add(arr[i]);
            }
            res.add(list);
            return;
        }
        if(n == graph.length-1) {
            return;
        }
        for (int i = 0; i < graph[a].length; i++) {
            arr[n+1] = graph[a][i];
            test(n+1,arr,graph,res);
        }
    }


    //尝试用动态规划算可能路径的次数，没写完
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        int size = graph.length;
        boolean[][] dp = new boolean[size][size];
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }
        int[][] go = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                List<Integer> l = list.get(j);
                l.add(i);
            }
        }

        for (int i = 1; i <= size-1 ; i++) {
            if(dp[size-1][i])
                go[size-1][i] = 1;
        }
        for (int i = size-1; i > 0 ; i--) {
            for (int j = 0; j < size; j++) {

            }
        }
        return null;
    }
}

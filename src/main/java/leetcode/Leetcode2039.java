package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/3/20 0:31
 */
public class Leetcode2039 {
    public static void main(String[] args) {
        /*int[][] edges = {{0,1},{0,2},{1,2}};
        int[] patience = {0,10,10};*/

        int[][] edges = {{0,1},{1,2}};
        int[] patience = {0,2,1};
        Leetcode2039 body = new Leetcode2039();
        int res = body.networkBecomesIdle2(edges, patience);
        System.out.println(res);
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int[][] a = new int[n][n];
        for (int[] e:edges) {
            int u = e[0];
            int v = e[1];
            a[u][v] = 1;
            a[v][u] = 1;
        }
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        int l = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 1; j < n; j++) {
                    if(a[poll][j] == 1 && arr[j] == -1) {
                        arr[j] = l*2;
                        queue.add(j);
                    }
                }
            }
            ++l;
        }
        int max = 0,len,p,ans;
        for (int i = 1; i < n; i++) {
            len = arr[i];
            p = patience[i];
            ans = len;
            if(len > p) {
                ans = 2*len - (len-1)%p-1;
            }
            max = Math.max(max,ans);
        }
        return max+1;
    }

    public int networkBecomesIdle2(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            lists[u].add(v);
            lists[v].add(u);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        int l = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j:lists[poll]) {
                    if (arr[j] == -1) {
                        arr[j] = l * 2;
                        queue.add(j);
                    }
                }
            }
            ++l;
        }
        int max = 0, len, p, ans;
        for (int i = 1; i < n; i++) {
            len = arr[i];
            p = patience[i];
            ans = len;
            if (len > p) {
                ans = 2 * len - (len - 1) % p - 1;
            }
            max = Math.max(max, ans);
        }
        return max + 1;
    }

    public int networkBecomesIdle3(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            lists[u].add(v);
            lists[v].add(u);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        int l = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int max = 0, len, p, ans;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j:lists[poll]) {
                    if (j != 0 && arr[j] == -1) {
                        arr[j] = l * 2;
                        queue.add(j);
                        len = arr[j];
                        p = patience[j];
                        ans = len;
                        if (len > p) {
                            ans = 2 * len - (len - 1) % p - 1;
                        }
                        max = Math.max(max, ans);
                    }
                }
            }
            ++l;
        }
        return max + 1;
    }
}

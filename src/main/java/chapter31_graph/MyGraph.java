package chapter31_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lethe
 * @date 2021/11/9 23:23
 */
public class MyGraph {

    private int v;  //顶点个数
    private LinkedList<Integer> adj[];    //邻接表

    public MyGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s,int t) {  //无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if(s == t)
            return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        prev[s] = 0;
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if(!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, q);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    //递归打印s->t的路径
    private void print(int[] prev, int s, int t) {
        if(prev[t] != -1 && t != s) {
            print(prev,s,prev[t]);
        }
        System.out.println(t + " ");
    }

    //全局变量或者类成员变量
    boolean found = false;

    public void dfs(int s,int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }


    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found) return;
        visited[w] = true;
        if(w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if(!visited[q]) {
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }

    }
}

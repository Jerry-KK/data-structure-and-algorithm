package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/2/12 12:14
 */
public class Leetcode1020 {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,1,1,1,0,1,0,0},
                {1,1,0,0,0,1,0,1,1,1},
                {0,0,0,1,1,1,0,1,0,0},
                {0,1,1,0,0,0,1,0,1,0},
                {0,1,1,1,1,1,0,0,1,0},
                {0,0,1,0,1,1,1,1,0,1},
                {0,1,1,0,0,0,1,1,1,1},
                {0,0,1,0,0,1,0,1,0,1},
                {1,0,1,0,1,1,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,1}
        };
        Leetcode1020 body = new Leetcode1020();
        int i = body.numEnclaves(grid);
        System.out.println(i);
        System.out.println("==================");
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(1);
        System.out.println(stack2.peek());
        System.out.println(stack2.poll());
        System.out.println("==================");

        Deque<Integer> stack3 = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        stack3.push(2);
        stack3.push(8);
        System.out.println(stack3.peek());
        System.out.println(stack3.poll());
        System.out.println("==================");

        stack3.clear();
        stack3.offerLast(3);
        stack3.offerLast(5);
        System.out.println(stack3.pollFirst());
        System.out.println("==================");

        ArrayDeque<Integer> stack4 = new ArrayDeque<Integer>(3);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int i = 0,j = 0;
        while (j < n-1)
            helper(grid,i,j++);
        while (i < m-1)
            helper(grid,i++,j);
        while (j > 0)
            helper(grid,i,j--);
        while (i > 0)
            helper(grid,i--,j);
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                if(grid[i][j] == 1)
                    ++res;
        return res;
    }

    private void helper(int[][] grid,int x,int y) {
        if(grid[x][y] == 1) {
            grid[x][y] = 2;
            if(x - 1 >= 0 )
                helper(grid,x-1,y);
            if(x + 1 < grid.length )
                helper(grid,x+1,y);
            if(y - 1 >= 0 )
                helper(grid,x,y-1);
            if(y + 1 < grid[0].length )
                helper(grid,x,y+1);
        }
    }

    /*
   [[0,0,0,1,1,1,0,1,0,0],
    [1,1,0,0,0,1,0,1,1,1],
    [0,0,0,1,1,1,0,1,0,0],
    [0,1,1,0,0,0,1,0,1,0],
    [0,1,1,1,1,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,0,1],
    [0,1,1,0,0,0,1,1,1,1],
    [0,0,1,0,0,1,0,1,0,1],
    [1,0,1,0,1,1,0,0,0,0],
    [0,0,0,0,1,1,0,0,0,1]]
     */

}

package leetcode;

/**
 * @author lethe
 * @date 2022/2/5 22:55
 */
public class Leetcode1219 {

    public static void main(String[] args) {
        Leetcode1219 body = new Leetcode1219();
        /*int[][] grid = {{1,0,7},
                        {2,0,6},
                        {3,4,5},
                        {0,3,0},
                        {9,0,20}};*/
        int[][] grid = {{1,6,1},
                        {5,8,7},
                        {1,9,1}};
        int maximumGold = body.getMaximumGold(grid);
        System.out.println(maximumGold);
    }

    public int getMaximumGold(int[][] grid) {
        int[] res = {0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    helper2(grid,i,j,grid[i][j],res);
                }
            }
        }
        return res[0];
    }

    private void helper(int[][] grid,int x, int y,int sum,int[] res) {
        if(getNums(grid,x,y) == 0 ) {
            res[0] = Math.max(res[0],sum);
        } else {
            int v = grid[x][y];
            grid[x][y] = 0;
            if(x-1 >= 0 && grid[x-1][y] != 0) {
                helper(grid,x-1,y,sum + grid[x-1][y],res);
            }
            if(x+1 < grid.length && grid[x+1][y] != 0) {
                helper(grid,x+1,y,sum + grid[x+1][y],res);
            }
            if(y-1 >= 0 && grid[x][y-1] != 0) {
                helper(grid,x,y-1,sum + grid[x][y-1],res);
            }
            if(y+1 < grid[0].length && grid[x][y+1] != 0) {
                helper(grid,x,y+1,sum + grid[x][y+1],res);
            }
            grid[x][y] = v;
        }
    }

    private int getNums(int[][] grid,int x, int y) {
        int nums = 0;
        if(x-1 >= 0 && grid[x-1][y] != 0) {
            ++nums;
        }
        if(x+1 < grid.length && grid[x+1][y] != 0) {
            ++nums;
        }
        if(y-1 >= 0 && grid[x][y-1] != 0) {
            ++nums;
        }
        if(y+1 < grid[0].length && grid[x][y+1] != 0) {
            ++nums;
        }
        return nums;
    }

    private void helper2(int[][] grid,int x, int y,int sum,int[] res) {
        int v = grid[x][y];
        grid[x][y] = 0;
        boolean flag = true;
        if(x-1 >= 0 && grid[x-1][y] != 0) {
            helper(grid,x-1,y,sum + grid[x-1][y],res);
            flag = false;
        }
        if(x+1 < grid.length && grid[x+1][y] != 0) {
            helper(grid,x+1,y,sum + grid[x+1][y],res);
            flag = false;
        }
        if(y-1 >= 0 && grid[x][y-1] != 0) {
            helper(grid,x,y-1,sum + grid[x][y-1],res);
            flag = false;
        }
        if(y+1 < grid[0].length && grid[x][y+1] != 0) {
            helper(grid,x,y+1,sum + grid[x][y+1],res);
            flag = false;
        }
        if(flag)
            res[0] = Math.max(res[0],sum);
        grid[x][y] = v;
    }
}

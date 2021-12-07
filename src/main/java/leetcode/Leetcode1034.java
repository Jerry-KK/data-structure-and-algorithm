package leetcode;

/**
 * @author koujn
 * @date 2021/12/7 17:19
 */
//todo
public class Leetcode1034 {

    public static void main(String[] args) {
        Leetcode1034 body = new Leetcode1034();
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        grid = body.colorBorder(grid,1,1,2);
        System.out.println(1);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int tar = grid[row][col];
        test(grid,row,col,color);
        test(grid,row,col,tar);
        return grid;
    }

    private void test(int[][] grid,int row, int col, int color) {
        int tar = grid[row][col];
        grid[row][col] = color;
        if(row-1>=0 && grid[row-1][col] == tar)
            test(grid,row-1,col,color);
        if(row+1<grid.length && grid[row+1][col] == tar)
            test(grid,row+1,col,color);
        if(col-1>=0 && grid[row][col-1] == tar)
            test(grid,row,col-1,color);
        if(col+1<grid[0].length && grid[row][col+1] == tar)
            test(grid,row,col+1,color);
    }

}

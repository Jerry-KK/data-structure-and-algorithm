package leetcode.efficientwinning;

/**
 * @author lethe
 * @date 2022/3/12 0:18
 */
public class Leetcode968 {

    int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        if(dfs(root) == 0)
            ++ans;
        return ans;
    }

    private int dfs(TreeNode node) {
        if(node == null)
            return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 0 || right == 0) {
            ++ans;
            return 2;
        }
        if(left == 1 && right == 1) {
            return 0;
        }
        return 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

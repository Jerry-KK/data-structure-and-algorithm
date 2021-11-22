package leetcode;

/**
 * @author koujn
 * @date 2021/11/22 13:38
 */
public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if(node.left == null && node.right == null)
            return 1;
        int val = Integer.MAX_VALUE;
        if(node.left != null)
            val = Math.min(dfs(node.left),val);
        if(node.right != null)
            val = Math.min(dfs(node.right),val);
        return val+1;
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

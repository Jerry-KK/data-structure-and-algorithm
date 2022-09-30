package leetcode;

/**
 * @author lethe
 * @date 2022/9/2 2:06
 */
public class Leetcode687 {

    int r = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return r;
    }

    private int dfs(TreeNode node) {
        int lv = 0, rv = 0;
        boolean lf = false, rf = false;
        if(node.left != null) {
            lv = dfs(node.left);
            if(lf = (node.left.val == node.val)) {
                ++lv;
            }
        }
        if(node.right != null) {
            rv = dfs(node.right);
            if((rf = node.right.val == node.val)) {
                ++rv;
            }
        }
        int fv = Math.max(lv, rv);
        if(node.left != null && node.right != null && lf && rf)
            r = Math.max(lv + rv, r);
        else
            r = Math.max(fv, r);
        return !lf && !rf ? 0 : fv;
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

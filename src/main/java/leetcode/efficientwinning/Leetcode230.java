package leetcode.efficientwinning;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author lethe
 * @date 2022/3/11 23:57
 */
public class Leetcode230 {

    int n;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if(node != null) {
            dfs(node.left);
            if( n > 0) {
                --n;
                if(n == 0)
                    ans = node.val;
            }
            if(n > 0)
                dfs(node.right);
        }
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

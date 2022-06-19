package leetcode.efficientwinning;


/**
 * @author lethe
 * @date 2022/3/11 23:46
 */
public class Leetcode112 {

    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        flag = false;
        dfs(root,targetSum);
        return flag;
    }

    private void dfs(TreeNode node,int targetSum) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                if(targetSum == node.val)
                    flag = true;
            }else{
                int val = targetSum - node.val;
                dfs(node.left,val);
                dfs(node.right,val);
            }
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

package leetcode;

/**
 * @author koujn
 * @date 2021/11/18 9:17
 */
public class Leetcode563 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1,t1,t2);
        Leetcode563 body = new Leetcode563();
        int i = body.findTilt(t3);
        System.out.println(i);

    }

    private int sum = 0;

    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        bianli(root);
        return sum;
    }

    private TreeNode bianli(TreeNode node) {
        if(node.left != null)
            bianli(node.left);
        if(node.right != null)
            bianli(node.right);
        int l = node.left == null ? 0:node.left.val;
        int r = node.right == null ? 0:node.right.val;
        node.val += l+r;
        sum += Math.abs(l-r);
        return node;
    }




    public static class TreeNode {
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

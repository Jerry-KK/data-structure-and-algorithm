package leetcode;

/**
 * @author koujn
 * @date 2021/11/26 9:31
 */
public class Leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if(root.val > val)
                root = root.left;
            else if(root.val < val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if(root == null || root.val == val)    return root;
        return root.val > val ? searchBST2(root.left,val) : searchBST2(root.right,val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

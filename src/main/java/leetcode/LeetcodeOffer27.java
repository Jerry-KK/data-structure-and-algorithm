package leetcode;

import java.util.Objects;

/**
 * @author koujn
 * @date 2021/9/1 10:31
 */
public class LeetcodeOffer27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        test(root);
        return root;
    }

    public void test(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        test(node.left);
        test(node.right);
    }
}


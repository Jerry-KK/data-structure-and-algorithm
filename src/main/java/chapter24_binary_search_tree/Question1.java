package chapter24_binary_search_tree;

/**
 * @author koujn
 * @date 2021/11/22 11:22
 */

import chapter23_tree.TreeNode;

/**
 * 如何通过编程，求出一颗给定二叉树的确切高度
 */
public class Question1 {

    public int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        int left = getHeight(root.leftNode);
        int right = getHeight(root.rightNode);
        return Math.max(left,right) + 1;
    }

}

package leetcode;

/**
 * @author lethe
 * @date 2022/9/10 0:12
 */
public class Leetcode669 {

    /*
    [45,30,46,10,36,null,49,8,24,34,42,48,null,4,9,14,25,31,35,41,43,47,null,0,6,null,null,11,20,null,28,null,33,null,
    null,37,null,null,44,null,null,null,1,5,7,null,12,19,21,26,29,32,null,null,38,null,null,null,3,null,null,null,null,
    null,13,18,null,null,22,null,27,null,null,null,null,null,39,2,null,null,null,15,null,null,23,null,null,null,40,null,
    null,null,16,null,null,null,null,null,17]
    32
    44
     */

    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null) {
            if(root.val < low) {
                root = root.right;
            } else if(root.val > high){
                root = root.left;
            }else {
                break;
            }
        }
        if(root == null)
            return null;
        leftMethod(root, low);
        rightMethod(root,high);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        while (root != null) {
            if(root.val < low)
                root = root.right;
            else if(root.val > high)
                root = root.left;
            else
                break;
        }
        leftMethod(root, low);
        rightMethod(root,high);
        return root;
    }

    private TreeNode leftMethod(TreeNode node, int low) {
        if(node == null)
            return null;
        if(node.val < low)
            node = leftMethod(node.right, low);
        else
            node.left = leftMethod(node.left , low);
        return node;
    }

    private TreeNode rightMethod(TreeNode node, int high) {
        if(node == null)
            return null;
        if(node.val > high)
            node = rightMethod(node.left , high);
        else
            node.right = rightMethod(node.right , high);
        return node;
    }

    public TreeNode trimBST3(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        if(root.val < low)
            return trimBST3(root.right, low, high);
        else if(root.val > high)
            return trimBST3(root.left, low, high);
        root.left = trimBST3(root.left, low, high);
        root.right = trimBST3(root.right, low, high);
        return root;
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

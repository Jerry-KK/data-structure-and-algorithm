package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lethe
 * @date 2022/2/9 21:55
 */
public class Leetcode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        helper(root,String.valueOf(root.val),res);
        return res;
    }

    private void helper(TreeNode node,String str,List<String> res) {
        if(node.left == null && node.right == null) {
            res.add(str);
        }else {
            if(node.left != null)
                helper(node.left,str + "->" + node.left.val,res);
            if(node.right != null)
                helper(node.right,str + "->" + node.right.val,res);
        }
    }

    class TreeNode {
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

    //用队列实现广度搜索
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        if(root == null)
            return res;
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if(node.left == null && node.right == null) {
                res.add(path);
            }else {
                if(node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }
                if(node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }
        }
        return res;
    }

    //官方的回溯写法
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> res = new LinkedList<>();
        helper2(root,"",res);
        return res;
    }

    private void helper2(TreeNode node,String path,List<String> list) {
        if(node != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(node.val);
            if(node.left == null && node.right == null) {
                list.add(sb.toString());
            }else {
                sb.append("->");
                helper2(node.left,sb.toString(),list);
                helper2(node.right,sb.toString(),list);
            }
        }
    }
}





package chapter23_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lethe
 * @date 2021/7/29 21:47
 */
public class Tree {
    public static void main(String[] args) {
        int[] arr = new int[11];
        for (int i = 1; i <= 10; i++) {
            arr[i] = i;
        }
        TreeNode root = new TreeNode();
        root.val = 1;
        create(root);

        System.out.println("前序遍历===========");
        preOrder(root);
        System.out.println("中序遍历===========");
        inOrder(root);
        System.out.println("后序遍历===========");
        postOrder(root);
        System.out.println("层序遍历===========");
        cxOrderFirst(root);


    }

    static void create(TreeNode root) {
        int left = root.val * 2;
        int right = root.val * 2 + 1;

        if(left<=10) {
            TreeNode leftNode = new TreeNode();
            leftNode.val = left;
            root.leftNode = leftNode;
            create(leftNode);
        }
        if(right<=10) {
            TreeNode rightNode = new TreeNode();
            rightNode.val = right;
            root.rightNode = rightNode;
            create(rightNode);
        }
    }



    //前序遍历
    static void preOrder(TreeNode root) {
        System.out.println(root.val);
        if(root.leftNode != null)
            preOrder(root.leftNode);
        if(root.rightNode != null)
            preOrder(root.rightNode);
    }

    //中序遍历
    static void inOrder(TreeNode root) {
        if(root.leftNode != null)
            inOrder(root.leftNode);
        System.out.println(root.val);
        if(root.rightNode != null)
            inOrder(root.rightNode);
    }

    //后序遍历
    static void postOrder(TreeNode root) {
        if(root.leftNode != null)
            postOrder(root.leftNode);
        if(root.rightNode != null)
            postOrder(root.rightNode);
        System.out.println(root.val);
    }


    //层序遍历
    static void cxOrderFirst(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        cxOrder(list);
    }

    static private void cxOrder(List<TreeNode> list) {
        while (list.size() != 0) {
            TreeNode remove = list.remove(0);
            System.out.println(remove.val);
            if (remove.leftNode != null) {
                list.add(remove.leftNode);
            }
            if (remove.rightNode != null) {
                list.add(remove.rightNode);
            }
        }
    }


}

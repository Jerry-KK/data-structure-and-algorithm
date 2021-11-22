package chapter24_binary_search_tree.mytry;

import com.sun.corba.se.pept.encoding.InputObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 14:01
 */
public class MyTree {

    //前序遍历
    public List<Integer> preorder(MyTreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        preorderDfs(root,list);
        return list;
    }

    public void preorderDfs(MyTreeNode node,List<Integer> list) {
        if(node != null){
            list.add(node.val);
            preorderDfs(node.left,list);
            preorderDfs(node.right,list);
        }
    }

    public List<Integer> preorderByStack(MyTreeNode root) {
        if(root == null)
            return null;
        Stack<MyTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        MyTreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if(node == null) {
                node = stack.pop();
                node = node.right;
            }else {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }

    //中序遍历
    public List<Integer> inorder(MyTreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        inorderDfs(root,list);
        return list;
    }

    public void inorderDfs(MyTreeNode node,List<Integer> list) {
        if(node != null) {
            inorderDfs(node.left,list);
            list.add(node.val);
            inorderDfs(node.right,list);
        }
    }

    public List<Integer> inorderByStack(MyTreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if(node == null ){
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }else {
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }

    //后续遍历
    public List<Integer> postorder(MyTreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        postorderDfs(root,list);
        return list;
    }

    public void postorderDfs(MyTreeNode node,List<Integer> list) {
        if(node != null){
            postorderDfs(node.left,list);
            postorderDfs(node.right,list);
            list.add(node.val);
        }
    }

    public List<Integer> postorderByStack(MyTreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if(node == null ) {
                node = stack.peek();
                if(node.right == null) {
                    stack.pop();
                    list.add(node.val);
                }else {
                    node = node.right;
                }
            }else {
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }
}

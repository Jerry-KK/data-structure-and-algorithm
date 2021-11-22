package chapter24_binary_search_tree.mytry;

/**
 * @author koujn
 * @date 2021/11/22 14:55
 */
public class MyBinarySearchTree {

    private MyTreeNode root;

    public MyTreeNode find(int v) {
        MyTreeNode node = root;
        while (node != null) {
            if(node.val > v)
                node = node.left;
            else if(node.val < v)
                node = node.right;
            else
                return node;
        }
        return null;
    }

    public void add(int v) {
        if(root == null)
            root = new MyTreeNode(v);
        else {
            MyTreeNode node = root;
            while (true) {
                if(node.val > v) {
                    if(node.left == null) {
                        node.left =new MyTreeNode(v);
                        return;
                    }
                    node = node.left;
                }else{
                    if(node.right == null) {
                        node.right =new MyTreeNode(v);
                        return;
                    }
                    node = node.right;
                }
            }
        }
    }

    public void delete(int v) {
        MyTreeNode pp = null;
        MyTreeNode p = root;
        while (p != null) {
            pp = p;
            if(p.val > v)
                p = p.left;
            else if(p.val < v)
                p = p.right;
            else
                break;
        }
        if(p.left != null && p.right != null) {
            MyTreeNode minPp = p;
            MyTreeNode minP = p.right;
            while (p.left != null){
                minPp = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            pp = minPp;
            p = minP;
        }

        MyTreeNode child = null;
        if(p.left != null)
            child = p.left;
        if(p.right != null)
            child = p.right;
        if(pp == null)      //删除的是根节点
            root = child;
        else if(pp.right == p)
            pp.right = child;
        else
            pp.left = child;
    }
}

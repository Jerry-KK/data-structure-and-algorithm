package chapter24_binary_search_tree;

/**
 * 二叉查找树
 * @author koujn
 * @date 2021/9/8 10:45
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if(p.data > data)
                p = p.left;
            else if(p.data < data)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    public void insert(int data) {
        if(tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if(data > p.data) {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data!= data) {
            pp = p;
            if(data > p.data)   p = p.right;
            else p = p.left;
        }
        if(p == null) return;
        if(p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (p.left != null) {
                minPP = minP;
                p = p.left;
            }
            p.data = minP.data;
            pp = minPP;
            p = minP;
        }

        Node child;
        if(p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        if(pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}


package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/3/10 21:28
 */
public class Leetcode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        helper(root,ans);
        return ans;
    }

    private void helper(Node node,List<Integer> ans) {
        if(node != null) {
            ans.add(node.val);
            node.children.forEach(c->helper(c,ans));
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}



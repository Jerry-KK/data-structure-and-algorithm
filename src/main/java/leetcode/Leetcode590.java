package leetcode;

import leetcode.efficientwinning.Leetcode968;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/3/12 13:07
 */
public class Leetcode590 {

    List<Integer> result;

    public List<Integer> postorder(Node root) {
        result = new LinkedList<>();
        dfs(root);
        return result;
    }

    private void dfs(Node node) {
        if(node != null) {
            for (Node c:node.children) {
                dfs(c);
            }
            result.add(node.val);
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

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author koujn
 * @date 2021/11/10 11:41
 */
public class Leetcode133 {

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node n = new Node(node.val);
        while (queue.size() > 0 ) {
            //queue.add()
        }
        return n;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}

package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lethe
 * @date 2021/11/21 16:02
 */
public class Leetcode559 {

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<Node> newQueue = new LinkedList<>();
            ++res;
            while (!queue.isEmpty())
                newQueue.addAll(queue.poll().children);
            if(newQueue.size() == 0)
                break;
            queue = newQueue;
        }
        return res;
    }

    public int maxDepth2(Node root) {
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int res = 0;
        int size  = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            ++res;
            int nextSize = 0;
            for (int i = 0; i < size; i++) {
                List<Node> children = queue.poll().children;
                queue.addAll(children);
                nextSize+=children.size();
            }
            size = nextSize;
        }
        return res;
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
    };
}

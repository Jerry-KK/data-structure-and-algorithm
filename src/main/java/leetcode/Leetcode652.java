package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/9/5 22:00
 */
public class Leetcode652 {

    Map<String,Integer> map;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private String helper(TreeNode node) {
        if(node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(").append(helper(node.left)).append(")");
        sb.append("[").append(helper(node.right)).append("]");
        String s = sb.toString();
        if(!map.containsKey(s)) {
            map.put(s,1);
        }else if(map.get(s) == 1) {
            res.add(node);
            map.put(s,2);
        }
        return s;
    }

    private String helper2(TreeNode node) {
        if(node == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(").append(helper(node.left)).append(")");
        sb.append("[").append(helper(node.right)).append("]");
        String s = sb.toString();
        if(!map.containsKey(s))
            map.put(s,1);
        else if(map.get(s) == 1 && res.add(node))
            map.put(s,2);
        return s;
    }

    int idx = 0;
    Map<String,Integer> idxMap;
    private int helper3(TreeNode node) {
        if(node == null)
            return 0;
        String key = node.val + " " +  helper3(node.left) + " " +  helper3(node.right);
        map.putIfAbsent(key, 0 );
        if(!map.containsKey(key)) {
            map.put(key, 1);
            idxMap.put(key, ++idx);
            return idx;
        } else if(map.get(key) == 1){
            res.add(node);
            map.put(key, 2);
        }
        return idxMap.get(key);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

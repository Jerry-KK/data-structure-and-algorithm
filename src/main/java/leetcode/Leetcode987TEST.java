package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的垂序遍历
 * @author lethe
 * @date 2021/7/31 21:27
 */
public class Leetcode987TEST {
    public static void main(String[] args) {
        verticalTraversal(null);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        valList.add(-1);
        valList.add(3);
        valList.add(9);
        valList.add(20);
        valList.add(-1);
        valList.add(-1);
        valList.add(15);
        valList.add(7);
        int length = valList.size();
        int[] colArr = new int[length+1];
        colArr[1] = 0;
        for (int i = 1; i < length; i++) {
            if(valList.get(i) != -1) {
                int index = 2 * i;
                if (index < length) {
                    colArr[index] = colArr[i] - 1;
                }
                index++;
                if (index < length) {
                    colArr[index] = colArr[i] + 1;
                }
            }
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(valList.get(i) != -1) {
                int finalI = i;
                map.compute(Integer.valueOf(colArr[finalI]),(k, v) -> {
                    if(v == null) {
                        v = new ArrayList<Integer>();
                    }
                    v.add(valList.get(finalI));
                    return v;
                });
            }
        }

        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}



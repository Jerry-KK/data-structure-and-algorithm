package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的垂序遍历
 * @author lethe
 * @date 2021/7/31 21:27
 */
public class Leetcode987 {
    public static void main(String[] args) {

        //[0,null,1,2,3,null,null,4,5]

        //[3,9,20,null,null,15,7]
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        List<List<Integer>> lists = verticalTraversal(n1);
        System.out.println(lists);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        valList.add(-1);
        cengxubianli(valList,nodeList);
        int length = valList.size();
        int[] colArr = new int[length+1];
        int[] rowArr = new int[length+1];
        colArr[1] = 0;
        rowArr[1] = 0;
        for (int i = 1; i < length; i++) {
            if(valList.get(i) != -1) {
                int index = 2 * i;
                if (index < length) {
                    colArr[index] = colArr[i] - 1;
                    rowArr[index] = rowArr[i] + 1;
                }
                index++;
                if (index < length) {
                    colArr[index] = colArr[i] + 1;
                    rowArr[index] = rowArr[i] + 1;
                }
            }
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(valList.get(i) != -1) {
                int finalI = i;
                map.compute(colArr[finalI],(k, v) -> {
                    if(v == null) {
                        v = new ArrayList<Integer>();
                    }
                    v.add(finalI);
                    return v;
                });
            }
        }
        for (Map.Entry<Integer,List<Integer>> e:map.entrySet()){
            int[] indexArr = e.getValue().stream().mapToInt(i->i).toArray();
            if(indexArr.length  == 1 ) {
                ArrayList<Integer> finalValList = new ArrayList<>();
                finalValList.add(valList.get(indexArr[0]));
                e.setValue(finalValList);
                continue;
            }
            for (int i = 1; i < indexArr.length; i++) {
                int j = i-1;
                int tmp = indexArr[i];
                if(!mySort(indexArr,rowArr,valList,i,j)) {
                    continue;
                }
                while (mySort(indexArr,rowArr,valList,i,j)) {
                    j--;
                }
                for (int k = i; k > j+1; k--) {
                    System.out.println(k);
                    indexArr[k] = indexArr[k-1];
                }
                indexArr[j+1] = tmp;
            }
            ArrayList<Integer> finalValList = new ArrayList<>();
            for (int i = 0; i < indexArr.length; i++) {
                finalValList.add(valList.get(indexArr[i]));
            }
            e.setValue(finalValList);
        }

        List<List<Integer>> res = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return res;

        /*int length = valList.size();
        List<Integer> colList = new ArrayList<>(length);
        colList.add(null);
        colList.add(0);
        for (int i = 1; i < length; i++) {
            int index = 2 * i;
            while (index < length) {
                colList.set(index,colList.get(i) - 1);
            }
            index++;
            while (index < length) {
                colList.set(index,colList.get(i) + 1);
            }
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(valList.get(i) != null) {
                int finalI = i;
                map.compute(colList.get(i),(k, v) -> {
                    if(v == null) {
                        v = new ArrayList<Integer>();
                    }
                    v.add(valList.get(finalI));
                    return v;
                });
            }
        }

        List<List<Integer>> arr = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return arr;*/
    }

    private static boolean mySort(int[] indexList,int[] rowArr,List<Integer> valList,int i,int j) {
        if(rowArr[indexList[i]] < rowArr[indexList[j]]) {
            return true;
        } else if(rowArr[indexList[i]] == rowArr[indexList[j]]) {
            if(valList.get(indexList[i]) < valList.get(indexList[j]))  {
                return true;
            }
        }
        return false;
    }


    private static void cengxubianli(List<Integer> res,List<TreeNode> treeNodeList) {
        if(treeNodeList.size() == 0) {
            return;
        }
        TreeNode remove = treeNodeList.remove(0);
        if(remove == null) {
            res.add(-1);
            cengxubianli(res,treeNodeList);
        }else {
            res.add(remove.val);
            treeNodeList.add(remove.left);
            treeNodeList.add(remove.right);
            cengxubianli(res,treeNodeList);
        }
    }


    private static void zhongxuSort(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        zhongxuSort(node.left,list);
        zhongxuSort(node.right,list);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class NodeInfo {
    int val;
    int row;
    int col;

    public NodeInfo() {}

    public NodeInfo(int val,int row,int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

}

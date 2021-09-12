package leetcode;

/**
 * @author lethe
 * @date 2021/9/3 12:42
 * 面试题 17.14. 最小K个数
 */

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Leetcode1714 {

    //数组转二叉树，然后前序遍历结果

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,2,4,6,8};
        int[] arr2 = new Leetcode1714().smallestK(arr1, 4);
        for (int x : arr2) {
            System.out.println(x);
        }
    }

    public int[] smallestK(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }

        if(arr.length == 0) {
            return new int[0];
        }
        MyNode myNode = new MyNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            add(myNode,arr[i]);
        }
        int[] res = new int[k];
        n  = 0;
        select(myNode,res);
        return res;
    }

    private int n;

    public void select(MyNode node,int[] res) {
        if(node.leftNext != null)
            select(node.leftNext,res);
        if(n == res.length) {
            return;
        }
        res[n] = node.val;
        ++n;
        if(node.rightNext != null)
                select(node.rightNext,res);
    }

    public void add(MyNode node,int val) {
        if(val< node.val) {
            if(node.leftNext == null) {
                MyNode n = new MyNode(val);
                node.leftNext = n;
                return;
            }else
                add(node.leftNext,val);
        }else {
            if(node.rightNext == null) {
                MyNode n = new MyNode(val);
                node.rightNext = n;
                return;
            }else
                add(node.rightNext,val);
        }
    }

    class MyNode {
        int val;
        MyNode leftNext;
        MyNode rightNext;

        public MyNode(int val){
            this.val = val;
        }
    }
}

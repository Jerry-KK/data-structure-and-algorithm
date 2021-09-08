package leetcode;


import chapter24_binary_search_tree.BinarySearchTree;

/**
 * @author koujn
 * @date 2021/9/8 9:15
 */
public class Leetcode502 {

    public static void main(String[] args) {
        /*int[] profits = {1,2,3};
        int[] capital = {0,1,2};
        int maximizedCapital = findMaximizedCapital(3, 0, profits, capital);*/

        int[] profits = {1,65,71,76,3,4,56,84};
        int[] capital = {1,65,71,76,3,4,56,84};
        Leetcode502 body = new Leetcode502();
        int maximizedCapital = body.findMaximizedCapital2(1, 65, profits, capital);
        System.out.println(maximizedCapital);
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //设置一个队列，放入可以选择的项目，遍历选利润最高
        //做过的项目移除或设置标记位
        //项目太多需要预处理
        boolean[] a = new boolean[capital.length];
        for (int i = 0; i < k; i++) {
            int v = 0;
            int n  = -1;
            for (int j = 0; j < capital.length; j++) {
                if(!a[j] && capital[j] <= w && profits[j] > v) {
                    v = profits[j];
                    n = j;
                }
            }
            if(n == -1) {
                break;
            }
            w+=v;
            a[n] = true;
        }
        return w;
    }

    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        //1.先对capital排序
        //2.每个根据w读取capital元素进入二叉树，二叉树根据profits值排序，同时记录capital扫描到那里，保证排序后的capital每个扫描一次

        //1:
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        quickSort(capital,index,0,n-1);

        //2:
        int a = 0;
        for (int i = 0; i < k; i++) {
            for (; a < n; a++) {
                if(capital[a] <= w) {
                    insert(profits[index[a]]);
                }else {
                    break;
                }
            }
            int v = findMaxAndDel();
            if(v == 0) break;
            w+=v;
        }
        return w;
    }

    void quickSort(int[] capital,int[] index,int start, int end) {
        if(start >= end) {
            return;
        }
        int q = partition(capital,index,start,end);
        quickSort(capital,index,start,q-1);
        quickSort(capital,index,q+1,end);
    }

    int partition(int[] capital,int[] index,int start, int end) {
        int v  = capital[end];
        int i = start , j = start;
        while (j < end) {
            if(capital[j] < v) {
                swap(capital,i,j);
                swap(index,i,j);
                i++;
            }
            j++;
        }
        swap(capital,i,end);
        swap(index,i,end);
        return i;
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;
        //对于大量重复值，两种解决方案
        //设置same指针用链表存储，链表插入删除较快，同时避免搜索二叉树层级过高
        private Node same;
        //设置size变量存储相同值数据，相比same指针，速度稍快，空间占用大。
        //private int size;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node tree;

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
            }else if(data < p.data){
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
                Node s = new Node(data);
                s.same = p.same;
                p.same = s.same;
                break;
            }
        }
    }

    public int findMaxAndDel() {
        if(tree == null) {
            return 0;
        }
        Node p = tree;
        Node pp = null;
        while (p.right != null) {
            pp = p;
            p = p.right;
        }
        if(p.same != null) {
            p.same = p.same.same;
        }else {
            if(pp == null ) tree = p.left;
            else pp.right = p.left;
            return p.data;
        }
        return p.data;
    }

}

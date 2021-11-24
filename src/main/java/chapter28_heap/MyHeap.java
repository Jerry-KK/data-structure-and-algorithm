package chapter28_heap;

/**
 * @author koujn
 * @date 2021/11/24 10:34
 */
public class MyHeap {

    //数组，从下标1开始存储数据
    private int[] a;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public MyHeap(int capacity) {
        n = capacity;
        a = new int[capacity+1];
        count = 0;
    }

    public void insert(int data) {
        if(n == count)
            return; //堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            swap(a,i,i/2);  //swap()函数作用：交换下标为i和i/2的两个元素
            i/=2;
        }
    }

    public void removeMax() {
        if(count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a,count,1);
    }

    private void heapify(int[] a,int n, int i) {
        while (true) {
            int maxPos = i;
            if( i*2 <= n && a[i] < a[i*2])
                maxPos = i*2;
            if( i*2+1 <= n && a[maxPos] < a[i*2+1] )
                maxPos = i*2+1;
            if(maxPos == i)
                break;
            swap(a,i,maxPos);
            i = maxPos;
        }
    }

    public void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a,n,i);
        }
    }

    //堆排序
    //n表示数据的个数,数组a中的数据从下标1到n的位置
    public void sort(int[] a, int n) {
        buildHeap(a,n);
        int k = n;
        while (k > 1) {
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i]^a[j];
        a[j] = a[i]^a[j];
        a[i] = a[i]^a[j];
    }
}

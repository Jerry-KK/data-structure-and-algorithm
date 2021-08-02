package chapter28_heap;

/**
 * @author koujn
 * @date 2021/8/2 16:38
 */
public class Heap {
    private int[] arr;  //数组,从下标1开始存储数据
    private int n;      //堆可以存储的最大数据个数
    private int count;  //堆中已经存储的数据个数

    public Heap(int capacity) {
        arr = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    //往堆中插入元素
    public void insert(int data) {
        if(n == count) {
            return;     //堆满了
        }
        ++count;
        arr[count] = data;
        int i = count;
        //自下往上堆化
        //i/2可以无视节点是父节点的左节点还是右节点
        while (i/2 > 0 && arr[i] > arr[i/2]) {
            //swap()函数作用：交换下标为i和i/2的两个元素
            swap(arr,i,i/2);
            i = i/2;
        }
    }

    //删除堆顶元素
    public void removeMax() {
        if(count <= 1) return;
        arr[1] = arr[count];
        --count;
        int i = 1;
        while (i*2 <=count) {
            int j = i*2;
            if(j < count && arr[j] < arr[j+1]) {
                ++j;
            }
            if(arr[i] < arr[j]) {
                swap(arr,i,j);
                i = j;
            }else {
                return;
            }
        }
    }

    //建堆
    private void createHeap(int[] arr, int n) {
        int i = n/2;
        for (; i > 0 ; i--) {
            int j = i;
            int k = j;
            while (true) {
                if(j*2 >= n && arr[j] < arr[j*2])
                    k = j*2;
                if(j*2 > n && arr[k] < arr[j*2+1])
                    k = j*2+1;
                if(k == j)
                    break;
                //swap()函数作用：交换下标为i和i/2的两个元素
                swap(arr,j,k);
                j = k;
            }
        }
    }

    //堆排序
    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    public void sort(int[] arr, int n) {
        for (int i = n; i > 1 ; i--) {
            int tmp = arr[n];
            arr[n--] = arr[1];
            arr[1] = tmp;
            int j = 1;
            while (true) {
                int max = j;
                if(j*2 <= n && arr[j] < arr[j*2])
                    max = j*2;
                if(j*2 < n && arr[max] < arr[j*2+1])
                    max = j*2+1;
                if(max == j)
                    break;
                swap (arr,j,max);
                j = max;
            }
        }

    }

    private void swap(int[] arr,int i,int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}

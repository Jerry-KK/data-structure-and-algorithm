package chapter12_sorts;

/**
 * @author lethe
 * @date 2021/7/25 23:46
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,65,7,2,4,};
        quickSort(arr,8);
        for (int i:arr) {
            System.out.println(i);
        }
    }

    // 快速排序，A是数组，n表示数组的大小
    public static void quickSort(int[] arr,int n) {
        quickSort(arr, 0, n-1);
    }
    // 快速排序递归函数，p,r为下标

    public static void quickSort(int[] arr,int p,int r) {
        if(p >= r) {
            return;
        }
        int q = partition(arr, p, r); // 获取分区点
        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);
    }

    public static int partition(int[] arr,int p,int r) {
        int pivot = arr[r];
        int i = p,j = p;
        for (; i < r;i++) {
            if(arr[i] < pivot) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }
        arr[r] = arr[j];
        arr[j] = pivot;
        return j;
    }
}

package chapter11_sorts;


/**
 * @author koujn
 * @date 2021/7/23 14:05
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 4,6,7,2,5,9};
        insertionSort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if(n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i-1;
            for (; j >= 0; j--) {
                //每次判断完后移一个元素
                if(a[j] > value) {
                   a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}

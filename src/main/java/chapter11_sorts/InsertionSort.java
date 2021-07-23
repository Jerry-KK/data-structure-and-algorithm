package chapter11_sorts;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(a[j] > tmp) {
                   a[j] = a[j-1];
                }else {
                    break;
                }
            }
            a[j] = tmp;
        }
    }
}

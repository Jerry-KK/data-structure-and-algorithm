package chapter11_sorts;

/**
 * 选择排序
 * @author koujn
 * @date 2021/9/6 11:31
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 4,6,7,2,5,9};
        selectionSort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n-1; i++) {
            int t = i;
            int v = a[i];
            for (int j = i+1; j < n; j++) {
                if(a[j] < v) {
                    t = j;
                    v = a[j];
                }
            }
            if(t != i) {
                a[t] = a[i];
                a[i] = v;
            }
        }
    }
}

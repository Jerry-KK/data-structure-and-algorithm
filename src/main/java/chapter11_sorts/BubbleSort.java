package chapter11_sorts;

/**
 * @author koujn
 * @date 2021/7/23 13:37
 */
public class BubbleSort {

    //冒泡排序
    public void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

}

package chapter11_sorts;

/**
 * @author koujn
 * @date 2021/7/23 13:37
 */
public class BubbleSort {

    //冒泡排序
    public void bubbleSort(int[] a, int n) {
        if(n <= 1) {
            return;
        }
        boolean flag;
        for (int i = 0; i < n; i++) {
            //标记位,true代表单次冒泡排序没有发生修改
            flag = true;
            for (int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) {
                return;
            }
        }
    }

}

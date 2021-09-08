package leetcode;

/**
 * 面试题 17.14. 最小K个数
 * 插入排序写法，速度很慢
 * @author lethe
 * @date 2021/9/6 18:00:00
 */
public class Leetcode17_14 {

    public int[] smallestK(int[] arr, int k) {
        int[] a = new int[k];
        a[0] = arr[0];
        for (int i = 1; i < k; i++) {
            int j = i-1;
            int v = arr[i];
            for (;j>=0;j--) {
                if(a[j] > v) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = v;
        }
        for (int i = k; i < arr.length ; i++) {
            int v  = arr[i];
            if(a[k-1] > v ) {
                int j  = k-2;
                for (; j >= 0; j--) {
                    if(a[j] > v) {
                        a[j+1] = a[j];
                    }else {
                        break;
                    }
                }
                a[j+1] = v;
            }
        }
        return a;
    }
}

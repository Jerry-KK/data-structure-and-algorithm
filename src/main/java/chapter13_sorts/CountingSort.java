package chapter13_sorts;

/**
 * @author lethe
 * @date 2021/7/26 23:07
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,65,7,2,4,3,5,2,1,65,7,2,4,1};
        countingSort(arr,arr.length);
        for (int i:arr) {
            System.out.println(i);
        }
    }

    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {
        if( n <= 1) {
            return;
        }
        // 查找数组中数据的范围
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max+1];
        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }
        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i-1];
        }
        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n-1; i >= 0 ; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

}

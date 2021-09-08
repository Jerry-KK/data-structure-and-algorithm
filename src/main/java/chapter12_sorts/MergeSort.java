package chapter12_sorts;

/**
 * @author lethe
 * @date 2021/7/25 23:22
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,65,7,2,4};
        mergeSort(arr,8);
        for (int i:arr) {
            System.out.println(i);
        }
    }

    // 归并排序算法, A是数组，n表示数组大小
    public static void mergeSort(int[] arr,int n) {
        mergeSort(arr,0,n-1);
    }

    // 递归调用函数
    public static void mergeSort(int[] arr,int p,int r) {
        if(p >= r) {
            return;
        }
        int n = p + (r - p)/2;
        mergeSort(arr, p, n);
        mergeSort(arr, n + 1, r);
        merge2(arr,p,n,r);
    }

    public static void merge(int[] arr, int p, int n,int r){
        int[] res = new int[r-p+1];
        int num = 0, i = p, j = n+1;
        while (i<=n && j <= r) {
            if(arr[i] < arr[j]) {
                res[num++] = arr[i++];
            } else {
                res[num++] = arr[j++];
            }
        }
        if(i > n) {
            while (num <= r-p) {
                res[num++] = arr[j++];
            }
        }else {
            while (num <= r-p) {
                res[num++] = arr[i++];
            }
        }
        for (int k = p,x = 0; k <=r ; k++) {
            arr[k] = res[x++];
        }
    }

    public static void merge2(int[] arr, int p, int n,int r){
        int[] res = new int[r-p+1];
        int num = 0, i = p, j = n+1;
        while (i<=n && j <= r) {
            if(arr[i] < arr[j]) {
                res[num++] = arr[i++];
            } else {
                res[num++] = arr[j++];
            }
        }

        //尝试减少if else
        int start = i,end = n;
        if(j <= r){
            start = j;
            end = r;
        }
        while (start <= end) {
            res[num++] = arr[start++];
        }

        for (int k = p,x = 0; k <=r ; k++) {
            arr[k] = res[x++];
        }
    }

    public static void merge3(int[] arr, int p, int n,int r){
        int[] res = new int[r-p+1];
        int num = 0, i = p, j = n+1;

        //设置哨兵
        //取左右两数组最后一位比较，判断出最后一位在左边还是右边
        //未完成
        int start = j,end = r;
        if(arr[n] > arr[r]){
            start = i;
            end = n;

        }
        while (start++<=end) {
            if(arr[i] < arr[j]) {
                res[num++] = arr[i++];
            } else {
                res[num++] = arr[j++];
            }
        }
        for (int k = p,x = 0; k <=r ;) {
            arr[k++] = res[x++];
        }
    }
}

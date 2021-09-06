package chapter11_sorts;

/**
 * 希尔排序
 * @author koujn
 * @date 2021/9/6 17:01
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 4,6,7,2,5,9};
        shellSort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shellSort(int[] a,int n) {
        int d = n;
        while (d > 1) {
            d = d/2;
            for (int i = 0; i < d; i++) {
                for (int j = i+d; j < n; j+=d) {
                    int s = j-d;
                    int v = a[j];
                    for ( ; s>=0 && a[s]>v ;s-=d) {
                        a[s+d] = a[s];
                    }
                    a[s+d] = v;
                }
            }
        }
    }

    public static void sort(int [] array){
        //希尔排序的增量
        int d=array.length;
        while(d>1) {
            // 使用希尔增量的方式，即每次折半
            d=d/2;
            for(int x=0;x<d;x++) {
                for(int i=x+d;i<array.length;i=i+d) {
                    int temp=array[i];
                    int j;
                    for(j=i-d;j>=0&&array[j]>temp;j=j-d) {
                        array[j+d]=array[j];
                    }
                    array[j+d]=temp;
                }
            }
        }
    }

}

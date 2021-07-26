package chapter14_binary_search;

/**
 * @author lethe
 * @date 2021/7/27 0:27
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,4,56,65,71,76,84};
        System.out.println(binarySearch(arr,arr.length,56));
        System.out.println(bsearch(arr,arr.length,56));
    }

    public static int binarySearch(int[] a, int n, int value) {
        int index = n/2;
        int i = 2;
        while ( n/i > 1) {
            if(a[index-1] == value){
                return index-1;
            }
            if(a[index-1] < value) {
                index = (index+1+n)/2;
            }else {
                index = index/2;
            }
            i*=2;
        }
        return -1;
    }

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
//            int mid = (low + high)/2;
            //如果 low 和 high 比较大的话，两者之和就有可能会溢出
//            int mid = low + (high-low)/2;
            int mid = low + (high-low)>>1;
            if(a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static double getSquareRoot(double num) {
        //
        return num;
    }


}

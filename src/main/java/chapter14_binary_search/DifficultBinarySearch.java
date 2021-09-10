package chapter14_binary_search;

/**
 * 4种常见的二分查找变形问题
 *  1.查找第一个值等于给定值的元素
 *  2.查找最后一个值等于给定值的元素
 *  3.查找第一个大于等于给定值的元素
 *  4.查找最后一个小于等于给定值的元素
 * @author koujn
 * @date 2021/9/10 14:45
 */
public class DifficultBinarySearch {

    //1.查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if(low < n && a[low]==value) return low;
        else return -1;
    }

    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] < value) {
                low = mid + 1;
            } else {
                if((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //2.查找最后一个值等于给定值的元素
    public int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid] > value) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if(high >= 0 || a[high] == value) return high;
        else return -1;
    }

    public int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] < value) {
                low = mid + 1;
            } else {
                if(mid == n-1 || a[mid+1] != value) return mid;
                else low = mid+1;
            }
        }
        return -1;
    }

    //3.查找第一个大于等于给定值的元素
    public int bsearch5(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] >= value) {
                if(mid == 0 || a[mid-1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //4.查找最后一个小于等于给定值的元素
    public int bsearch6(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if(a[mid] <= value) {
                if(mid == n - 1 || a[mid+1] > value) return mid;
                else low = mid;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

}

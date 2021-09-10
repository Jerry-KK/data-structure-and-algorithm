package leetcode;

/**
 * @author koujn
 * @date 2021/9/10 9:08
 */
public class Leetcode1894 {

    public static void main(String[] args) {
        int[] chalk = {5,1,5};
        Leetcode1894 body = new Leetcode1894();
        int r = body.chalkReplacer(chalk, 22);
        System.out.println(r);
    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if(chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            chalk[i]+=chalk[i-1];
            if(chalk[i] > k) {
                return i;
            }
        }
        k = k%chalk[n-1];
        return binarySearch(chalk,k);
    }

    public int binarySearch(int[] a,int k) {
        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid] > k){
                if(mid == 0 || a[mid - 1] <= k) return mid;
                else high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] a,int k) {
        int low = 0;
        int high = a.length-1;
        while (low < high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid] > k)  high = mid;
            else    low = mid + 1;
        }
        return high;
    }
}

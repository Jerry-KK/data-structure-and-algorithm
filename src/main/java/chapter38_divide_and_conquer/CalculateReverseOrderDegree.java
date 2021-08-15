package chapter38_divide_and_conquer;

/**
 * 如何编程求出一组数据的有序对个数或者逆序对个数
 * @author lethe
 * @date 2021/8/15 19:34
 */
public class CalculateReverseOrderDegree {

    private int num = 0;

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if(p >= r)  return;
        int q = (p+r)/2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1,r);
        merge(a,p,q,r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            }else {
                num+=(q-i+1);
                tmp[k++] = a[j++];
            }
            while (i <= q) {
                tmp[k++] = a[i++];
            }
            while (j <= r) {
                tmp[k++] = a[j++];
            }
            for (int l = 0; l < k; l++) {
                a[p+l] = tmp[l];
            }
        }
    }
}

package leetcode;

/**
 * @author koujn
 * @date 2021/8/27 12:37
 */
public class Leetcode295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }
}
//如果数据流中所有整数都在 0 到 100 范围内
class MedianFinder {

    int size;
    int[] arr;

    /** initialize your data structure here. */
    public MedianFinder() {
        size = 0;
        arr = new int[101];
    }

    public void addNum(int num) {
        arr[num]++;
        size++;
    }

    public double findMedian() {
        int a = size/2 + size%2;
        int b = size%2;
        for (int i = 0,n = 0; i < 101; i++) {
            n+= arr[i];
            if( a <= n ) {
                if(b == 0 && a == n)
                    return 0.5 + i;
                else
                    return i;
            }

        }
        return 0;
    }
}

class MedianFinder2 {

    int size;
    int[] arr;

    /** initialize your data structure here. */
    public MedianFinder2() {
        size = 0;
        arr = new int[101];
    }

    public void addNum(int num) {
        arr[num]++;
        size++;
    }

    public double findMedian() {
        int a = size/2 + size%2;
        int b = size%2;
        for (int i = 0,n = 0; i < 101; i++) {
            n+= arr[i];
            if( a <= n ) {
                if(b == 0 && a == n)
                    return 0.5 + i;
                else
                    return i;
            }

        }
        return 0;
    }
}

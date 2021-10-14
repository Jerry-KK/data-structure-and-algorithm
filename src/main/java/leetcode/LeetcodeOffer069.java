package leetcode;

/**
 * @author koujn
 * @date 2021/10/14 9:20
 */
public class LeetcodeOffer069 {
    public static void main(String[] args) {
        LeetcodeOffer069 body = new LeetcodeOffer069();
        int[] arr = {3,4,5,1};
        int index = body.peakIndexInMountainArray(arr);
        System.out.println(index);
    }


    public int peakIndexInMountainArray(int[] arr) {
        //int low = 0;
        //int high = arr.length-1;
        return search2(arr,0,arr.length-1);
    }

    public int search(int[] arr,int low,int high) {
        /** 右移的优先级低于+号  */
        //int mid = (high - low)>>1 + low;      //这里先执行1 + low ， 答案错误
        //int mid = low + (high - low)>>1;      //这里先执行low + (high - low)， 答案错误
        int mid =  low + ((high - low)>>1);     //加了括号，答案正确
        if(arr[mid] < arr[mid-1]){
            mid = search(arr,low,mid);
        } else if(arr[mid] < arr[mid+1]) {
            mid = search(arr,mid,high);
        }
        return mid;
    }

    public int search2(int[] arr,int low,int high) {
        /** 右移的优先级低于+号  */
        //int mid = (high - low)>>1 + low;      //这里先执行1 + low ， 答案错误
        //int mid = low + (high - low)>>1;      //这里先执行low + (high - low)， 答案错误
        int mid =  low + ((high - low)>>1);     //加了括号，答案正确
        if(arr[mid] < arr[mid-1])
            mid = search2(arr,low,mid);
        else if(arr[mid] < arr[mid+1])
            mid = search2(arr,mid,high);
        return mid;
    }
}

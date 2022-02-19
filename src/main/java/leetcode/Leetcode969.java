package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/2/19 16:43
 */
public class Leetcode969 {

    public static void main(String[] args) {
        Leetcode969 body = new Leetcode969();
        int[] arr = {3,2,4,1};
        List<Integer> list = body.pancakeSort(arr);
        list.forEach(System.out::println);
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new LinkedList<>();
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] != i+1) {
                int j = 0;
                for (; j < i; j++) {
                    if(arr[j] == i+1) {
                        break;
                    }
                }
                help(arr,j+1);
                res.add(j+1);
                help(arr,i+1);
                res.add(i+1);
            }
        }
        return res;
    }

    private void help(int[] arr,int k) {
        for (int i = 0; i < (k>>1); i++) {
            int idx = k-i-1;
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

}

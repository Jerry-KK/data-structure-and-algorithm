package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lethe
 * @date 2022/2/21 16:45
 */
public class Leetcode838 {
    public static void main(String[] args) {
        Leetcode838 body = new Leetcode838();
        String s = body.pushDominoes("RR.L");
        System.out.println(s);
    }

    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'L') {
                for (int j = i-1; j >= k; --j) {
                    arr[j] = 'L';
                }
                k = i+1;
                i = k-1;
            }else if(arr[i] == 'R') {
                for (int j = i+1; j < arr.length ; j++) {
                    if(arr[j] == 'L') {
                        k = j+1;
                        while (i < j){
                            arr[i++] = 'R';
                            arr[j--] = 'L';
                        }
                        if( i == j) {
                            arr[i] = '.';
                        }
                        i = k-1;
                        break;
                    }else if(arr[j] == 'R') {
                        i = j-1;
                        k = j+1;
                        break;
                    } else {
                        arr[j] = 'R';
                    }
                }
            }
        }
        return String.valueOf(arr);
    }

}

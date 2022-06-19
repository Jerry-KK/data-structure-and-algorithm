package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/3/6 20:08
 */
public class Leetcode2100 {

    public static void main(String[] args) {
        int[] security = {5,3,3,3,5,6,2};
        Leetcode2100 body = new Leetcode2100();
        List<Integer> ans = body.goodDaysToRobBank2(security, 2);
        ans.forEach(System.out::println);
    }

    //超时
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new LinkedList<>();
        for (int i = time; i < security.length - time; i++) {
            boolean flag = true;
            for (int j = 1; j <= time; j++) {
                if(security[i-j] < security[i-j+1] || security[i+j] < security[i+j-1]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> goodDaysToRobBank2(int[] security, int time) {
        int l = security.length;
        int[] incrArr = new int[l];
        int[] decrArr = new int[l];
        for (int i = 1; i < l; i++) {
            if(security[i] >= security[i-1]) {
                incrArr[i] = incrArr[i-1]+1;
            }
            if(security[i] <= security[i-1]) {
                decrArr[i] = decrArr[i-1]+1;
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = time; i < security.length - time; i++) {
            if(decrArr[i] - decrArr[i-time] == time && incrArr[i+time] - incrArr[i] == time ) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> goodDaysToRobBank3(int[] security, int time) {
        int l = security.length;
        //自左往右(i)递增的天数
        int[] left = new int[l];
        //自右往左(i)递增的天数
        int[] right = new int[l];
        for (int i = 1; i < l; i++) {
            if(security[i] <= security[i-1]) {
                left[i] = left[i-1]+1;
            }
            if(security[l-i-1] <= security[l-i]) {
                right[l-i-1] = right[l-i]+1;
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = time; i < security.length - time; i++) {
            if(right[i] >= time && left[i] >= time ) {
                ans.add(i);
            }
        }
        return ans;
    }

}

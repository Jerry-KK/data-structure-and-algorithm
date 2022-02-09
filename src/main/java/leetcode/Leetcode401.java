package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lethe
 * @date 2022/2/9 22:30
 */
public class Leetcode401 {

    private int[] tArr = {1,2,4,8,16,32,1,2,4,8};

    public static void main(String[] args) {
        Leetcode401 body = new Leetcode401();
        List<String> list = body.readBinaryWatch(4);
        list.sort((a,b)->{
            String[] s1 = a.split(":");
            String[] s2 = b.split(":");
            if(s1[0].equals(s2[0])) {
                return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            }
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });
        list.forEach(System.out::println);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new LinkedList<>();
        helper(turnedOn,0,new int[10],new int[2],res);
        return res;
    }

    private void helper(int turnedOn,int i,int[] arr,int[] time,List<String> res) {
        if( turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(time[0]);
            sb.append(":");
            if(time[1] < 10) sb.append("0");
            sb.append(time[1]);
            res.add(sb.toString());
        }else {
            for (; i < 6; i++) {
                if(arr[i] == 0 && time[1] + tArr[i] < 60) {
                    time[1] += tArr[i];
                    arr[i] = 1;
                    helper(turnedOn - 1,i + 1,arr,time,res);
                    time[1] -= tArr[i];
                    arr[i] = 0;
                }
            }
            for (;i<10;++i) {
                if(arr[i] == 0 && time[0] + tArr[i - 6] <= 11) {
                    time[0] += tArr[i];
                    arr[i] = 1;
                    helper(turnedOn - 1,i+1,arr,time,res);
                    time[0] -= tArr[i];
                    arr[i] = 0;
                }
            }
        }
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> list = new LinkedList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                    list.add(h + ":" + (m< 10 ? "0" : "") + m);
        return list;
    }

    public List<String> readBinaryWatch3(int turnedOn) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i>>6,m = i&63;
            if(h < 12 && m < 60 && Integer.bitCount(i) == turnedOn)
                list.add(h + ":" + (m< 10 ? "0" : "") + m);
        }
        return list;
    }
}

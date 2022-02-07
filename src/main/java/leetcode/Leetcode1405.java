package leetcode;

import java.util.PriorityQueue;

/**
 * @author lethe
 * @date 2022/2/7 20:31
 */
public class Leetcode1405 {

    public static void main(String[] args) {
        Leetcode1405 body = new Leetcode1405();
        long start = System.currentTimeMillis();
        String s = body.longestDiverseString2(4, 42, 7);
        long end = System.currentTimeMillis();
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(end-start);
    }

    // 回溯超时
    public String longestDiverseString(int a, int b, int c) {
        String[] res = {""};
        helper(a,b,c,"",res);
        return res[0];
    }

    private void helper(int a, int b, int c,String str,String[] res) {
        if(a >= 0 && b >= 0 && c>= 0) {
            int num = 0;
            if(a == 0) ++num;
            if(b == 0) ++num;
            if(c == 0) ++num;
            if(num == 2) {

                if(a > 0)
                    str = a > 1 ? str + "aa" : str + "a";
                else if(b > 0)
                    str = b > 1 ? str + "bb" : str + "b";
                else
                    str = c > 1 ? str + "cc" : str + "c";
                if(str.length() > res[0].length()) {
                    res[0] = str;
                    System.out.println(str);
                }
            }else {
                char ch = str.length() == 0 ? 'd' : str.charAt(str.length()-1);
                if(ch != 'a') {
                    helper(a-1,b,c,str+"a",res);
                    helper(a-2,b,c,str+"aa",res);
                }
                if(ch != 'b') {
                    helper(a,b-1,c,str+"b",res);
                    helper(a,b-2,c,str+"b",res);
                }
                if(ch != 'c') {
                    helper(a,b,c-1,str+"c",res);
                    helper(a,b,c-2,str+"cc",res);
                }
            }
        }
    }

    //贪心 + 大顶堆
    public String longestDiverseString2(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[0]-x[0]);
        if(a > 0) maxHeap.add(new int[]{a,'a'});
        if(b > 0) maxHeap.add(new int[]{b,'b'});
        if(c > 0) maxHeap.add(new int[]{c,'c'});
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] maxArr = maxHeap.poll();
            char ch = (char)maxArr[1];
            int l = sb.length();
            if(l >= 2 && sb.charAt(l-1) == ch && sb.charAt(l-2) == ch) {
                if(maxHeap.isEmpty())
                    break;
                int[] nextArr = maxHeap.poll();
                --nextArr[0];
                char ch2 = (char)nextArr[1];
                sb.append(ch2);
                if(nextArr[0] > 0)
                    maxHeap.offer(nextArr);
                maxHeap.offer(maxArr);
            }else {
                sb.append(ch);
                --maxArr[0];
                if(maxArr[0] > 0)
                    maxHeap.offer(maxArr);
            }
        }
        return sb.toString();
    }

}

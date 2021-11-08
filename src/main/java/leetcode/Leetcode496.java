package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author koujn
 * @date 2021/10/26 17:07
 */
public class Leetcode496 {

    public static void main(String[] args) {
        Leetcode496 body = new Leetcode496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = body.nextGreaterElement2(nums1,nums2);
        System.out.println(res);
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        int[] a3 = new int[n2];
        a3[n2-1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n2-1],n2-1);
        for (int i = n2-2; i >= 0; --i) {
            map.put(nums2[i],i);
            a3[i] = nums2[i+1] > nums2[i] ? nums2[i+1] : a3[i+1];
        }
        for (int i = 0; i < n1; i++)
            res[i] = a3[map.get(nums1[i])];
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n2-1; i >= 0; --i) {
            int x = nums2[i];
            while (!d.isEmpty() && d.peekLast() <= x)
                d.pollLast();
            map.put(x, d.isEmpty() ? -1 : d.peekLast());
            d.addLast(x);
        }
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++)
            res[i] = map.get(nums1[i]);
        return res;
    }

}

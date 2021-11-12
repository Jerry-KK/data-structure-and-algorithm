package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/12 10:49
 */
public class Leetcode495_2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums2.length];
        int[] res = new int[nums1.length];
        for (int i = nums2.length-1; i >= 0 ; --i) {
            map.put(nums2[i],i);
            while (!stack.isEmpty()) {
                if (stack.peek() < nums2[i])
                    stack.pop();
                else
                    break;
            }
            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = arr[map.get(nums1[i])];
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = nums2.length-1; i >= 0 ; --i) {

            while (!stack.isEmpty()) {
                if (stack.peek() < nums2[i])
                    stack.pop();
                else
                    break;
            }
            map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; ++i)
            res[i] = map.get(nums1[i]);
        return res;
    }
}

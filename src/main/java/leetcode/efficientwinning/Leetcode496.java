package leetcode.efficientwinning;

import java.util.*;

/**
 * @author lethe
 * @date 2022/3/9 18:49
 */
public class Leetcode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>(l2);
        int[] ans = new int[l1];
        int[] arr = new int[l2];
        Arrays.fill(arr,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < l2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                arr[map.get(stack.pop())] = i;
            }
            map.put(nums2[i],i);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < l1; i++) {
            int idx = map.get(nums1[i]);
            ans[i] = arr[idx] == -1 ? -1 : nums2[arr[idx]];
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>(l2);
        int[] ans = new int[l1];
        Deque<Integer> stack = new ArrayDeque<>(nums2.length);
        for (int i = 0; i < l2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(),nums2[i]);
            }
            map.put(nums2[i],-1);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < l1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

}

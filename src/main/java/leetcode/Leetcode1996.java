package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lethe
 * @date 2022/1/30 23:24
 */
public class Leetcode1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->a[0] == b[0] ? (a[1] > b[1] ? -1 : 1) : a[0] < b[0] ? -1 : 1);
        Stack<Integer> stack = new Stack<>();
        int attack = 0;
        int sum = 0;
        for (int[] arr:properties) {
            if(arr[0] == attack) {
                stack.push(arr[1]);
            }else {
                while (!stack.isEmpty() && stack.peek() < arr[1]) {
                    stack.pop();
                    ++sum;
                }
                stack.push(arr[1]);
                attack = arr[0];
            }
        }
        return sum;
    }

    //超时
    public int numberOfWeakCharacters2(int[][] properties) {
        int sum = 0;
        int[] arr = new int[properties.length];
        for (int i = 0; i < properties.length; i++) {
            for (int j = i+1; j < properties.length; j++) {
                if(properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]) {
                    arr[j] = 1;
                }else if(properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]) {
                    arr[i] = 1;
                }
            }
        }
        for (int n:arr) {
            if(n == 1)
                ++sum;
        }
        return sum;
    }

    //时间消耗和内存消耗都比方法1多
    public int numberOfWeakCharacters3(int[][] properties) {
        Map<int[],Integer> map = new HashMap<>();
        for (int[] arr:properties)
            map.put(arr,map.getOrDefault(arr,0) + 1);
        List<int[]> keys = map.keySet()
                .stream()
                .sorted((a, b) -> a[0] == b[0] ? (a[1] > b[1] ? -1 : 1) : a[0] < b[0] ? -1 : 1)
                .collect(Collectors.toList());
        Stack<int[]> stack = new Stack<>();
        int attack = 0;
        int sum = 0;
        for (int[] arr:keys) {
            if(arr[0] != attack) {
                while (!stack.isEmpty() && stack.peek()[1] < arr[1])
                    sum+=map.get(stack.pop());
                attack = arr[0];
            }
            stack.push(arr);
        }
        return sum;
    }


    public int numberOfWeakCharacters4(int[][] properties) {
        Arrays.sort(properties,(a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int maxDef = 0;
        int sum = 0;
        for (int[] arr:properties) {
            if(arr[1] < maxDef)
                ++sum;
            else
                maxDef = arr[1];
        }
        return sum;
    }

    public int numberOfWeakCharacters5(int[][] properties) {
        Arrays.sort(properties,(a,b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int[] arr:properties) {
            while (!stack.isEmpty() && stack.peek() < arr[1]) {
                stack.pop();
                ++sum;
            }
            stack.push(arr[1]);
        }
        return sum;
    }

}

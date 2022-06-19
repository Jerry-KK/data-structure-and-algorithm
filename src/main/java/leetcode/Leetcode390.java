package leetcode;

import java.util.Stack;

/**
 * @author lethe
 * @date 2022/1/2 20:32
 */
public class Leetcode390 {
    public static void main(String[] args) {
        Leetcode390 body = new Leetcode390();
        int res = body.lastRemaining(10000000);
        int res2 = body.lastRemaining2(10000000);
        System.out.println(res);
        System.out.println(res2);
    }

    public int lastRemaining(int n) {
        Stack<Integer> stack1= new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = n; i > 0; i--) {
            stack1.add(i);
        }
        while (stack1.size() > 1 ) {
            while (true) {
                if (stack1.isEmpty())
                    break;
                else
                    stack1.pop();
                if (stack1.isEmpty())
                    break;
                else
                    stack2.add(stack1.pop());
            }
            Stack<Integer> tmp = stack1;
            stack1 = stack2;
            stack2 = tmp;
        }
        return stack1.peek();
    }

    public int lastRemaining2(int n) {
        int[] arr = new int[n+1];
        int[] arr2 = new int[n+1];
        for (int i = 0; i <= n ; i++)
            arr[i] = i;
        int size = n;
        while (true) {
            if(size > 1) {
                int j = 0;
                for (int i = 1; i < size; i+=2,j++)
                    arr2[j] = arr[i];
                size = j;
            }else {
                return arr[0]+1;
            }
            if(size > 1) {
                int j = size/2-1;
                for (int i = size-2; i >= 0; i-=2,j--)
                    arr[j] = arr2[i];
                size /=2;
            }else {
                return arr2[0]+1;
            }
        }
    }

    public int lastRemaining3(int n) {
        int[] arr = new int[n+1];
        int[] arr2 = new int[n+1];
        for (int i = 0; i <= n ; i++)
            arr[i] = i;
        int size = n;
        while (true) {
            if(size > 1) {
                int j = 0;
                for (int i = 1; i < size; i+=2,j++)
                    arr2[j] = arr[i];
                size = j;
            }else {
                return arr[0]+1;
            }
            if(size > 1) {
                int j = size/2-1;
                for (int i = size-2; i >= 0; i-=2,j--)
                    arr[j] = arr2[i];
                size /=2;
            }else {
                return arr2[0]+1;
            }
        }
    }
}

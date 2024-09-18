package codecrush;

import java.util.*;

public class Solution2208 {

    public static void main(String[] args) {
        System.out.println(quack("qqqqqqqqqquuuuuuuuuuaaaaaaaaaacccccccccckkkkkkkkkk"));
        System.out.println(quack("quackquack"));
        System.out.println(quack("quqackuack"));
        System.out.println(quack("quacuuack"));
    }

    public static int quack(String str){
        if(str == null || str.isEmpty())
            return 0;
        String quackStr = "quack";
        Map<Character, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < quackStr.length(); i++)
            map.put(quackStr.charAt(i), new ArrayDeque<>());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Deque<Integer> tmpDeque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Deque<Integer> deque = map.get(c);
            deque.offerLast(i);
        }
        Deque<Integer> startDeque = map.get('q');
        if (startDeque.size() != str.length()/5 || str.length()%5 != 0)
            return -1;
        while (!startDeque.isEmpty()) {
            Integer idx = startDeque.pollFirst();
            while (!minHeap.isEmpty()) {
                if (minHeap.peek() < idx) {
                    minHeap.poll();
                    break;
                }
                tmpDeque.offerFirst(minHeap.poll());
            }
            while (!tmpDeque.isEmpty()) {
                minHeap.offer(tmpDeque.pollFirst());
            }

            for (int i = 1; i < quackStr.length(); i++) {
                Deque<Integer> deque = map.get(quackStr.charAt(i));
                if (deque.peekFirst() < idx) {
                    return -1;
                }
                idx = deque.pollFirst();
            }

            minHeap.offer(idx);
        }
        return minHeap.size();
    }

}

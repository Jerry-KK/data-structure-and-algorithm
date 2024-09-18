package codecrush;

import java.util.PriorityQueue;

public class Solution2207 {

    public int race(int[] t, int[] q, int n) {
        PriorityQueue<Integer> tHeap = new PriorityQueue<>();
        PriorityQueue<Integer> qHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            tHeap.offer(t[i]);
            qHeap.offer(q[i]);
        }
        int res = 0;
        while (tHeap.size() > 0) {
            if(tHeap.peek() > qHeap.peek()) {
                qHeap.poll();
                ++res;
            }
            tHeap.poll();
        }
        return res;
    }
}

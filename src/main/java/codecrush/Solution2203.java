package codecrush;

import java.util.HashMap;

public class Solution2203 {

    public static void main(String[] args) {
        int[] votes = {5, 3,5,4,5};
        System.out.println(select(votes, 5));
    }

    static int select(int[] votes, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(votes[i], map.getOrDefault(votes[i], 0) + 1);
            if (map.get(votes[i]) > n/2)
                return votes[i];
        }
        return -1;
    }

}

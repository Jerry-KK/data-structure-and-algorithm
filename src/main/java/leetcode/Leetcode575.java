package leetcode;

import java.util.HashSet;

/**
 * @author koujn
 * @date 2021/11/3 8:58
 */
public class Leetcode575 {

    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : candyType)
            set.add(j);
        return Math.min(candyType.length / 2, set.size());
    }

}

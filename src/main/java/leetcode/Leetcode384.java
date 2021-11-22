package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author koujn
 * @date 2021/11/22 9:32
 */
public class Leetcode384 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution body = new Leetcode384().new Solution(nums);
        int[] shuffle = body.shuffle();
        int[] shuffle2 = body.shuffle();
        int[] shuffle3 = body.shuffle();
        System.out.println(1);
    }

    class Solution {

        int[] initArr;
        Random random = new Random();

        public Solution(int[] nums) {
            initArr = nums;
        }

        public int[] reset() {
            return initArr;
        }

        public int[] shuffle() {
            int[] randomArr = initArr.clone();
            for (int i = 0; i < initArr.length; i++) {
                int r = random.nextInt(initArr.length - i);
                int v = randomArr[i];
                randomArr[i] = randomArr[i+r];
                randomArr[i+r] = v;
            }
            return randomArr;
        }
    }
}



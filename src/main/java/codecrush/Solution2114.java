package codecrush;

import java.util.HashMap;
import java.util.Map;

public class Solution2114 {

    public static void main(String[] args) {
        System.out.println(calScore("RGGR", "RBYG"));
    }



    public static int calScore(String solution, String guess) {
        Map<Character, Integer> solutionMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        int[] score = {0};
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                score[0] +=5;
                continue;
            }
            Character k = solution.charAt(i);
            solutionMap.put(k, solutionMap.getOrDefault(k, 0) + 1);
            Character k2 = guess.charAt(i);
            guessMap.put(k2, guessMap.getOrDefault(k2, 0) + 1);
        }
        solutionMap.forEach((k,v) -> score[0] += Math.min(v, guessMap.getOrDefault(k, 0)));
        return score[0];
    }


}

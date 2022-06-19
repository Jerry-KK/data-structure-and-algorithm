package leetcode;

import java.util.Random;

/**
 * @author lethe
 * @date 2022/6/5 17:30
 */
public class Leetcode478 {

    class Solution {

        double x,y,r;
        Random random;

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
            random = new Random();
        }

        public double[] randPoint() {
            while (true) {
                double rx = random.nextDouble() * (2 * r) - r;
                double ry = random.nextDouble() * (2 * r) - r;
                if(rx * rx + ry * ry <= r * r)
                    return new double[]{x + rx,y + ry};
            }
        }
    }
}

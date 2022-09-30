package leetcode;

/**
 * @author lethe
 * @date 2022/9/25 13:49
 */
public class Leetcode788 {

    public int rotatedDigits(int n) {
        //           0  1, 2, 3, 4, 5, 6, 7, 8, 9
        int[] arr = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            boolean f1 = false, f2 = true;      //f1 代表存在反转后称为其他数， f2 代表反转后不为数
            for (int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j)-'0';
                if(arr[idx] == 1)
                    f1 = true;
                else if(arr[idx] == -1)
                        f2 = false;
            }
            if(f1 && f2)
                ++sum;
        }
        return sum;
    }

}

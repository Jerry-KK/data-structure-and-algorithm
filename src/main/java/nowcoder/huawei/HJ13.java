package nowcoder.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author lethe
 * @date 2022/2/17 22:50
 */
public class HJ13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String[] arr = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i > 0; --i) {
                sb.append(arr[i]).append(" ");
            }
            sb.append(arr[0]);
            System.out.println(sb.toString());
        }
    }
}

package nowcoder.huawei;
import java.util.*;

/**
 * @author lethe
 * @date 2022/2/17 22:14
 */
public class HJ8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int size = Integer.parseInt(in.nextLine());
        for(int i = 0; i < size; ++i) {
            String str = in.nextLine();
            String[] arr = str.split(" ");
            int key = new Integer(arr[0]);
            int val = new Integer(arr[1]);
            map.put(key, map.getOrDefault(key,0) + val);
        }
        map.forEach((k,v)->System.out.println(k + " " + v));
    }
}

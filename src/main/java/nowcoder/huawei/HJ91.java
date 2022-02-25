package nowcoder.huawei;
import java.util.*;

/**
 * @author lethe
 * @date 2022/2/21 19:02
 */
public class HJ91 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int size = in.nextInt();
            int n1 = 0;
            int n2 = 0;
            int sum = 0;
            LinkedList<Integer> list = new LinkedList<>();
            int[] res = {0};
            for(int i = 0;i < size ;++i) {
                int v = in.nextInt();
                if(v % 5 == 0) {
                    n1 += v;
                } else if(v % 3 == 0) {
                    n2+=v;
                }else {
                    sum +=v;
                    list.add(v);
                }
            }
            if(((sum + n1 - n2)&1) == 1) {
                System.out.println("false");
            }else {
                int tar = (sum + n1 - n2)>>1;
                helper(tar,list,res);
                System.out.println(res[0]==1 ?"true" : "false");
            }
        }
    }

    private static void helper(int tar,LinkedList<Integer> list,int[] res) {
        if(res[0] == 0){
            if(list.size() == 0) {
                if(tar == 0) {
                    res[0] = 1;
                }
            } else {
                Integer v = list.remove();
                helper(tar,list,res);
                helper(tar-v,list,res);
                list.addFirst(v);
            }
        }
    }
}

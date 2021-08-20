package leetcode;

/**
 * @author koujn
 * @date 2021/8/20 9:18
 */
public class Leetcode541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("a", 2));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (true) {
            int j = i + k;
            if(j < chars.length) {
                fz(chars,i,j-1);
            }else {
              /*  if(chars.length-1 == i)
                    break;*/
                fz(chars,i,chars.length-1);
                break;
            }
            i = j + k;
            if(i >= chars.length)
                break;
        }
        return String.valueOf(chars);
    }

    private static void fz(char[] arr,int start,int end) {
        char[] tmp = new char[end-start+1];
        for (int k = end,i=0; k >= start; --k,++i) {
            tmp[i] = arr[k];
        }
        for (int i = start; i <= end ; i++) {
            arr[i] = tmp[i-start];
        }
    }
}

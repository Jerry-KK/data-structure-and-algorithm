package leetcode;

/**
 * @author lethe
 * @date 2023/2/25 0:56
 */
public class Leetcode1247 {

    public int minimumSwap(String s1, String s2) {
        int xy = 0,yx = 0, r = 0,l = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i < l; i++) {
            if(arr1[i] !=  arr2[i]) {
                if(arr1[i] == 'x')
                    ++xy;
                else
                    ++yx;
            }
        }
        if(((xy + yx)&1) == 1)
            return -1;
        return (xy>>1) + (yx>>1) + (xy&1) + (yx&1);
    }

    public int minimumSwap2(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int l = s1.length();
        int r = 0;
        for (int i = 0; i < l; i++) {
            if(arr1[i] != arr2[i]) {
                int j = i+1;
                for (; j < l; j++) {
                    if(arr1[j] != arr2[j]) {
                        r += arr1[i] == arr1[j] ? 1 : 2;
                        break;
                    }
                }
                if(j == l)
                    return -1;
                i = j;
            }
        }
        return r;
    }

}

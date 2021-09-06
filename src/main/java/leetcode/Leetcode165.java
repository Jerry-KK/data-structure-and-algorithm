package leetcode;

/**
 * @author koujn
 * @date 2021/9/1 9:58
 */
public class Leetcode165 {

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";

        Leetcode165 body = new Leetcode165();
        System.out.println(body.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int l1 = arr1.length;
        int l2 = arr2.length;
        int minL = l1 < l2 ? l1 : l2;

        for (int i = 0; i < minL; i++) {
            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]) ) {
                return -1;
            }
            if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]) ) {
                return 1;
            }
        }
        for (int i = minL; i < arr1.length; i++) {
            if(Integer.parseInt(arr1[i]) > 0) {
                return 1;
            }
        }
        for (int i = minL; i < arr2.length; i++) {
            if(Integer.parseInt(arr2[i]) > 0) {
                return -1;
            }
        }
        return 0;

    }

}

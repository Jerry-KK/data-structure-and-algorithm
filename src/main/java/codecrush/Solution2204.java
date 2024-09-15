package codecrush;

public class Solution2204 {

    public static void main(String[] args) {
        int[] dogHouses = {1,0,1,0,1,0,1};
//        int[] dogHouses = {0};
        System.out.println(placeDogs(dogHouses, 7, 2));
    }

    static boolean placeDogs(int[] dogHouses, int n, int k) {
        if (n == 0)
            return k <= 0;
        int last = 0;
        for (int i = 0; i < n-1 && k > 0; i++) {
            if (last == 0 && dogHouses[i] == 0 && dogHouses[i+1] == 0) {
                dogHouses[i] = 1;
                --k;
            }
            last = dogHouses[i];
        }
        if (last == 0 && dogHouses[n-1] == 0) {
            --k;
        }
        return k <= 0;
    }

}

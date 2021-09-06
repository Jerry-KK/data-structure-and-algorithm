package leetcode;

/**
 * @author koujn
 * @date 2021/8/31 9:11
 */
public class Leetcode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1] ; j++) {
                arr[j-1]+=bookings[i][2];
            }
        }
        return arr;
    }

    public int[]corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking: bookings) {
            nums[booking[0]-1]+=booking[2];
            if(booking[1] < n)
                nums[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++) {
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}

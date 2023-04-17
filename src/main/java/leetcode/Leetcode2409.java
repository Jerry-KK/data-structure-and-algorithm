package leetcode;

/**
 * @author lethe
 * @date 2023/4/17 22:40
 */
public class Leetcode2409 {

    static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] tmp = new int[13];
    static {
        for (int i = 1; i < 12; i++)
            tmp[i+1] = tmp[i] + month[i-1];
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int s = Math.max(str2Day(arriveAlice), str2Day(arriveBob));
        int l = Math.min(str2Day(leaveAlice), str2Day(leaveBob));
        return l >= s ? l - s + 1 : 0;
    }

    public int str2Day(String s) {
        int m = (char2Int(s.charAt(0))) * 10 + (char2Int(s.charAt(1)));
        int d = (char2Int(s.charAt(3))) * 10 + (char2Int(s.charAt(4)));
        return tmp[m] + d;
    }

    public int char2Int(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Leetcode2409 body = new Leetcode2409();
        int i = body.countDaysTogether("10-01", "10-31", "11-01", "12-31");
        System.out.println(i);
    }

}

package codecrush;

public class Solution2106 {

    private static final long currentTime = 1707838655485L;
    private static final long minus = 60000L;
    private static final long hour = 60L * minus;
    private static final long day = 24L * hour;;
    private static final long month = 30L * day;
    private static final long year = 365L * day;

    public static void main(String[] args) {
        System.out.println(formatTime(1707837875480L));
    }



    public static String formatTime(long timestamp) {
        long v = currentTime - timestamp;
        if (v >= year) {
            return v/year + "年前发布";
        } else if (v >= month) {
            return v/month + "个月前发布";
        } else if (v >= day) {
            return v/day + "天前发布";
        } else if (v >= hour) {
            return v/hour + "小时前发布";
        } else if (v >= minus) {
            return v/minus + "分钟前发布";
        }else {
            return "刚刚发布";
        }
    }
}

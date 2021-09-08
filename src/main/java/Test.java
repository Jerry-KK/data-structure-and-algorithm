import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * @author lethe
 * @date 2021/7/20 0:08
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime start = time.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = start.withHour(12).withMinute(0);

        LocalDateTime t1 = time;
        LocalDateTime t2 = start.plusMinutes(15);

        Date d1 = new Date();
        Date d2 = new Date(d1.getTime()+15*60*1000);
        String[] arr = new String[96];
        ArrayList<String> list = new ArrayList<>(96);

        long l1 = System.currentTimeMillis();
        for (int k = 0; k< 10000; k++) {
            for (int i = 0; i < 96; ) {
                //long x = (d2.getTime()-d1.getTime())/60000;
                list.add(String.valueOf(i));
                i+=2;
            }
            for (int i = 0; i < 96; i++) {
                //long l = Duration.between(t1, t2).toMinutes();
                arr[i] = String.valueOf(i);
            }
        }

        long l2 = System.currentTimeMillis();
        for (int k = 0; k< 10000; k++) {
            for (int i = 1; i < 97;) {
                //long l = Duration.between(t1, t2).toMinutes();
                arr[i] = String.valueOf(i);
                i+=2;
            }
        }
        long l3 = System.currentTimeMillis();


        System.out.println(l2-l1);
        System.out.println(l3-l2);

    }
}

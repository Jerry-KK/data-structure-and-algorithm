package codecrush;

import java.util.ArrayList;
import java.util.List;

public class Solution2104 {

    public static void main(String[] args) {
        List<String> list = split("  hello   world!", 'h');
        list.forEach(System.out::println);
    }

    public static List<String> split(String s, char t) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                if (sb.length() > 0 ) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() > 0 )
            list.add(sb.toString());
        return list;
    }

}

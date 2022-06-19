package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lethe
 * @date 2022/6/9 23:17
 */
public class Leetcode929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e:emails) {
            StringBuilder sb = new StringBuilder();
            char[] cs = e.toCharArray();
            int i = 0;
            for (;; i++) {
                if(cs[i] == '.')
                    continue;
                else if(cs[i] == '+' || cs[i] == '@' )
                    break;
                sb.append(cs[i]);
            }
            if(cs[i] == '+')
                for (;cs[i] != '@'; i++);
            sb.append(e.substring(i));
            set.add(sb.toString());
        }
        return set.size();
    }

}

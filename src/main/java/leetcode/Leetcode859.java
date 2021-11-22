package leetcode;

/**
 * @author lethe
 * @date 2021/11/23 0:12
 */
public class Leetcode859 {

    public boolean buddyStrings(String s, String goal) {
        if(s.length() == 1 || s.length() != goal.length())
            return false;
        Integer n = 0;
        boolean flag = false;
        int i = 0,j = -1;
        for (;i<s.length();++i) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(j == -1) {
                    j = i;
                }else if(j >= 0) {
                    if(s.charAt(j) != goal.charAt(i) || s.charAt(i) != goal.charAt(j))
                        return false;
                    j = -2;
                }else {
                    return false;
                }
            }
            if(!flag) {
                if( (n&(1<<(s.charAt(i)-'a'))) != 0)
                    flag = true;
                else
                    n+=(1<<(s.charAt(i)-'a'));
            }
        }
        return j == -2 || flag && j == -1;
    }
}

package leetcode;

/**
 * @author lethe
 * @date 2021/11/14 22:12
 */
//todo
public class Leetcode520 {

    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) {
            return true;
        }else {
            if( word.charAt(1)<='Z') {
                if(word.charAt(0) > 'Z')
                    return false;
                for (int i = 2; i < word.length(); ++i)
                    if(word.charAt(i) > 'Z')
                        return false;
                return true;
            }else {
                for (int i = 2; i < word.length(); ++i)
                    if(word.charAt(i)<='Z')
                        return false;
                return true;
            }
        }
    }

}

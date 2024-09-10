package codecrush;

public class Solution2112 {

    public boolean editWord(String wrongWord, String correctWord) {
        int l1 = wrongWord.length();
        int l2 = correctWord.length();
        if (Math.abs(l1 - l2) > 1)
            return false;
        for (int i = 0; i < l1 && i < l2; i++) {
            if (wrongWord.charAt(i) != correctWord.charAt(i)) {
                if (l1 > l2 ){
                    return wrongWord.substring(i + 1).equals(correctWord.substring(i));
                } else if (l2 > l1 ){
                    return wrongWord.substring(i).equals(correctWord.substring(i+1));
                } else {
                    return wrongWord.substring(i+1).equals(correctWord.substring(i+1));
                }
            }
        }
        return true;
    }
}

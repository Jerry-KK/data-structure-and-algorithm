package leetcode;

/**
 * @author lethe
 * @date 2021/12/18 13:28
 */
public class Leetcode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c:ransomNote.toCharArray())
            ++arr[c-'a'];
        for (char c:magazine.toCharArray())
            --arr[c-'a'];
        for (int i:arr)
            if(i > 0)
                return false;
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c:magazine.toCharArray())
            ++arr[c-'a'];
        for (char c:ransomNote.toCharArray())
            if(--arr[c-'a'] < 0)
                return false;
        return true;
    }

}

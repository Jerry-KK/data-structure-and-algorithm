package chapter35_trie_tree;

/**
 * @author koujn
 * @date 2021/8/12 11:21
 */
public class Trie {

    //存储无意义的字符
    private TrieNode root = new TrieNode('/');

    //在Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null) {
                p.children[index] = new TrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if(p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

}

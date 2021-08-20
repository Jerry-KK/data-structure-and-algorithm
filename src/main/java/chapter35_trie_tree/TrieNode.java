package chapter35_trie_tree;

/**
 * @author koujn
 * @date 2021/8/12 11:22
 */
public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) {
        this.data = data;
    }
}

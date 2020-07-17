package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 9:06
 * Description: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class Trie {

    private boolean isend;
    private char value;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isend = false;
        value = ' ';
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            if (trie.next[c-'a']!=null){
                trie = trie.next[c-'a'];
                if (i==word.length()-1){
                    trie.isend = true;
                }
            }else {
                Trie node = new Trie();
                node.next = new Trie[26];
                node.value = c;
                if (i==word.length()-1){
                    node.isend = true;
                }
                trie.next[c-'a'] = node;
                trie = node;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            if (trie.next[c-'a']!=null){
                trie = trie.next[c-'a'];
                if (i==word.length()-1){
                    return trie.isend;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        char[] chars = prefix.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            if (trie.next[c-'a']!=null){
                trie = trie.next[c-'a'];
                if (i==prefix.length()-1){
                    return true;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        boolean app = trie.startsWith("app");
        boolean app1 = trie.search("app");
        trie.insert("app");
        boolean app2 = trie.search("app");
        System.out.println();
    }
}

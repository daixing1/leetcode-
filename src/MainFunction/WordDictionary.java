package MainFunction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/30
 * Time: 23:17
 * Description: 设计一个支持以下两种操作的数据结构：
 *                  void addWord(word)
 *                  bool search(word)
 *              search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 */
public class WordDictionary {
//    private TrieTree trieTree;
//    /** Initialize your data structure here. */
//    public WordDictionary() {
//        trieTree = new TrieTree(-1,false);
//    }
//
//    /** Adds a word into the data structure. */
//    public void addWord(String word) {
//        for (int i=0;i<word.length();i++){
//            char c = word.charAt(i);
//            if (trieTree.getNext()[c-'a']!=null){
//                trieTree = trieTree.getNext()[c-'a'];
//            }else {
//                TrieTree tree = new TrieTree(c-'a',false);
//                trieTree.getNext()[c-'a'] = tree;
//                trieTree = trieTree.getNext()[c-'a'];
//            }
//        }
//        trieTree.setEnd(true);
//
//    }
//
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//        boolean flag = false;
//        for (int i=0;i<word.length();i++) {
//            char c = word.charAt(i);
//            if (c!='.'){
//                if (trieTree.getNext()[c-'a']!=null){
//                    trieTree = trieTree.getNext()[c-'a'];
//                }else {
//                    return false;
//                }
//            }else {
//                for (int j = 0;j<26;j++){
//                    if (trieTree.getNext()[j]!=null){
//
//                    }
//                }
//            }
//        }
//    }
//    private Set<String> set;
//    /** Initialize your data structure here. */
//    public WordDictionary() {
//        set = new HashSet<>();
//    }
//
//    /** Adds a word into the data structure. */
//    public void addWord(String word) {
//        set.add(word);
//    }
//
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//
//    }
//
//    private List<String> getAllWords(String word){
//
//    }
}

class TrieTree{
    private int c;
    private boolean isEnd;
    private TrieTree[] next;
    public TrieTree(int c, boolean isEnd){
        this.c = c;
        this.isEnd = isEnd;
        this.next = new TrieTree[26];
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public TrieTree[] getNext() {
        return next;
    }

    public void setNext(TrieTree[] next) {
        this.next = next;
    }
}

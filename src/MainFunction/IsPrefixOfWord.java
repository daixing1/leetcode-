package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 20:09
 * Description: 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用
 *              单个空格 分隔的单词组成。
 *              请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 *              如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 *              如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 *              如果 searchWord 不是任何单词的前缀，则返回 -1 。
 *              字符串 S 的 「前缀」是 S 的任何前导连续子字符串
 */
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i=0;i<split.length;i++){
            if (split[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}

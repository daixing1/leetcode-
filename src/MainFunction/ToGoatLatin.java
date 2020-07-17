package MainFunction;

import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/23
 * Time: 14:50
 * Description: 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *              我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *              山羊拉丁文的规则如下：
 *                  如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 *                  例如，单词"apple"变为"applema"。
 *                  如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *              例如，单词"goat"变为"oatgma"。
 *              根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 *              例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 *              返回将 S 转换为山羊拉丁文后的句子
 */
public class ToGoatLatin {
    public String toGoatLatin(String S) {
        if (S==null||"".equals(S)){
            return "";
        }
        StringBuilder res = new StringBuilder();
        List<Character> chars = Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
        String[] split = S.split(" ");
        for (int i=0;i<split.length;i++){
            if (chars.contains(split[i].charAt(0))){
                res.append(split[i]).append("ma").append("a".repeat(i+1));
            }else {
                res.append(split[i].substring(1)).append(split[i].charAt(0)).append("ma").append("a".repeat(i+1));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
}

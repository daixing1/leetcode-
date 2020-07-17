package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/4/29
 * Time: 11:56
 * Description: 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *              假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
 *              那么我们就认为你掌握了这个单词。
 *              注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *              返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        char[] chars1 = chars.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c:chars1){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for (String word:words){
            Map<Character,Integer> map1 = new HashMap<>(map);
            boolean flag = true;
            char[] wordChars = word.toCharArray();
            for (char c:wordChars){
                if (map1.containsKey(c)&&map1.get(c)>0){
                    map1.put(c,map1.get(c)-1);
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                len+=word.length();
            }
        }
        return len;
    }
}

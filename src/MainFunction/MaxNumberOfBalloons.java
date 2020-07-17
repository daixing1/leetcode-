package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/10
 * Time: 10:55
 * Description: 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *              字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<text.length();i++){
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
        }

        return Math.min(map.getOrDefault('a',0),Math.min(map.getOrDefault('b',0),
                Math.min(map.getOrDefault('l',0)/2,Math.min(map.getOrDefault('o',0)/2,
                        map.getOrDefault('n',0)))));
    }
}

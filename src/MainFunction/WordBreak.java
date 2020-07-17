package MainFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 9:09
 * Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一
 *              个或多个在字典中出现的单词。
 *              说明：
 *                  拆分时可以重复使用字典中的单词。
 *                  你可以假设字典中没有重复的单词。
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<wordDict.size();i++){
            for (int j=0;j<wordDict.get(i).length();j++){
                char c = wordDict.get(i).charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                return false;
            }
        }
        return wordBreak1(s,0,wordDict,new HashMap<>());
    }
    public static boolean wordBreak1(String s,int start, List<String> wordDict,Map<Integer,Boolean> map) {
        if (s.length()==start){
            return true;
        }
        if (map.containsKey(start)){
            return map.get(start);
        }
        boolean flag = false;
        boolean result = false;
        for (int i=0;i<wordDict.size();i++){
            if (s.contains(wordDict.get(i))){

                boolean b = wordBreak1(s,start+wordDict.get(i).length(), wordDict,map);
                result = flag||b;
                flag = b;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        boolean b = wordBreak("catsandog", Arrays.asList("cats", "dog", "san", "and", "cat"));
        System.out.println(b);
    }
}

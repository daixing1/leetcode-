package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/3/31
 * Time: 11:38
 * Description: 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 *              现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。
 *              例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 *              如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
 *              你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 */
public class WordSubsets {
    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> stringList = new ArrayList<>();
        Map<Character,Integer> mapA = new HashMap<>();
        Map<Character,Integer> mapB = new HashMap<>();
//        int[]
//        for (String b:B){
//            char[] chars = b.toCharArray();
//            for
//        }
        return stringList;
    }

    public static void main(String[] args) {
        List<String> stringList = wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"});
        System.out.println(stringList);
    }
}

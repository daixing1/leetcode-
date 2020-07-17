package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/7
 * Time: 9:07
 * Description: 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 *              如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 */
public class FindClosest {
    public static int findClosest(String[] words, String word1, String word2) {
        int dis = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<words.length;i++){
            if (words[i]==word1){
                map.put(word1,i);
                if (map.containsKey(word2)){
                    dis = Math.min(map.get(word1)-map.get(word2),dis);
                }
            }
            if (words[i]==word2){
                map.put(word2,i);
                if (map.containsKey(word1)){
                    dis = Math.min(map.get(word2)-map.get(word1),dis);
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int closest = findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student");
        System.out.println(closest);
    }
}

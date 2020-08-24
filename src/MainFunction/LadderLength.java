package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/4
 * Time: 22:57
 * Description: 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 *              的最短转换序列的长度。转换需遵循如下规则：
 *                  每次转换只能改变一个字母。
 *                  转换过程中的中间单词必须是字典中的单词。
 *              说明:
 *
 *                  如果不存在这样的转换序列，返回 0。
 *                  所有单词具有相同的长度。
 *                  所有单词只由小写字母组成。
 *                  字典中不存在重复的单词。
 *              你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class LadderLength {
    Set<String> set = new HashSet<>();
    int min = Integer.MAX_VALUE/2;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)){
            return 0;
        }
        int result = getResult(beginWord, endWord, wordList);
        if (result>=Integer.MAX_VALUE/2){
            return 0;
        }
        return result+1;
    }

    private int getResult(String beginWord, String endWord, List<String> wordList){
        List<String> allValid = getAllValid(beginWord, wordList);
        if (allValid.contains(endWord)){
            return 1;
        }
        set.add(beginWord);
        boolean flag = false;
        for (String s:allValid){
            if (set.contains(s)){
                continue;
            }else {
                flag = true;
                min = Math.min(min,getResult(s,endWord,wordList)+1);
            }
        }
        if (!flag){
            return Integer.MAX_VALUE/2;
        }
        return min;
    }

    private List<String> getAllValid(String word, List<String> wordList){
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String s:wordList){
            count = 0;
            for (int i=0;i<word.length();i++){
                if (word.charAt(i)!=s.charAt(i)){
                    count++;
                }
                if (count>1){
                    break;
                }
            }
            if (count==1){
                list.add(s);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        int i = ladderLength.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }
}

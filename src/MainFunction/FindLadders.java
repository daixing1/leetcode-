package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/7
 * Time: 9:10
 * Description: 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 *              的最短转换序列。转换需遵循如下规则：
 *                  每次转换只能改变一个字母。
 *                  转换过程中的中间单词必须是字典中的单词。
 *              说明:
 *                  如果不存在这样的转换序列，返回一个空列表。
 *                  所有单词具有相同的长度。
 *                  所有单词只由小写字母组成。
 *                  字典中不存在重复的单词。
 *                  你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class FindLadders {
    List<List<String>> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(wordList,new boolean[wordList.size()],list,endWord);
        List<List<String>> tmpWord = new ArrayList<>();
        for (List<String> arr:res){
            if (arr.size()==min){
                tmpWord.add(arr);
            }
        }
        return tmpWord;
    }

    public void dfs(List<String> wordList, boolean[] flag, List<String> list, String endWord){
        if (isTmpWord(list.get(list.size()-1),endWord)&&wordList.contains(endWord)){
            list.add(endWord);
            min = Math.min(min,list.size());
            res.add(new ArrayList<>(list));
            list.remove(endWord);
            return;
        }
        for (int i=0;i<wordList.size();i++){
            if (!flag[i]){
                if (isTmpWord(list.get(list.size()-1),wordList.get(i))){
                    list.add(wordList.get(i));
                    flag[i] = true;
                    dfs(wordList,flag,list,endWord);
                    list.remove(list.size()-1);
                    flag[i] = false;
                }
            }
        }
    }

    public boolean isTmpWord(String word1, String word2){
        int count = 0;
        for (int i=0;i<word1.length();i++){
            if (word1.charAt(i)!=word2.charAt(i)){
                count++;
                if (count>1){
                    return false;
                }
            }
        }
        if (count==1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        List<List<String>> ladders = findLadders.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladders);
    }
}

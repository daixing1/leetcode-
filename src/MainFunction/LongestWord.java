package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/30
 * Time: 10:01
 * Description: 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 *              若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 */
public class LongestWord {
    public static String longestWord(String[] words) {
        if (words.length<2){
            return "";
        }
        Arrays.sort(words,(o1,o2)->{
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else {
                return -o1.length()+o2.length();
            }
        });
        List<String> stringList = new ArrayList<>(Arrays.asList(words));
        for (String s:words){
//            if (s.length()==words[0].length()){
            while (stringList.contains(s)){
                stringList.remove(s);
            }
                if (find(stringList,s)){
                    return s;
                }
//            }
        }
        return "";
    }

    public static boolean find(List<String> ss, String word){
        if (word.length()==0){
            return true;
        }
        for (int i=0;i<ss.size();i++){
            if (word.startsWith(ss.get(i))&&find(ss,word.substring(ss.get(i).length()))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = longestWord(new String[]{"zoddld","god","o","oi","ozzbxoio","olgo","o","gblzdldxbz","xboolo"});
        System.out.println(s);
    }
}

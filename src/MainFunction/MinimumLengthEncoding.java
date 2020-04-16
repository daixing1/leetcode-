package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/3/28
 * Time: 9:07
 * Description: 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *              例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#"
 *              和 indexes = [0, 2, 5]。
 *              对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复
 *              我们之前的单词列表。
 *              那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class MinimumLengthEncoding {
    public static int minimumLengthEncoding(String[] words) {
        int n = 0;
        if (words.length==0){
            return n;
        }
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        for (int i=0;i<wordList.size()-1;){
            boolean flag = false;
            for (int j=i+1;j<wordList.size();j++){
                if (wordList.get(i).equals(wordList.get(j))){
                    wordList.remove(j);
                    break;
                }else if (wordList.get(i).endsWith(wordList.get(j))){
                    wordList.remove(j);
                    i++;
                    break;
                }else if (wordList.get(j).endsWith(wordList.get(i))){
                    wordList.remove(i);
                    break;
                }else {
                    flag = true;
                }
            }
            if (flag){
                i++;
            }
        }
        for (String word:wordList){
            n+=word.length()+1;
        }
        return n;
    }

    public static void main(String[] args) {
        int i = minimumLengthEncoding(new String[]{"aatime", "atime", "btime"});
        System.out.println(i);
    }
}

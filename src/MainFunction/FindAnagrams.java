package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 10:21
 * Description: 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *              字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *              说明：
 *                  字母异位词指字母相同，但排列不同的字符串。
 *                  不考虑答案输出的顺序。
 */
public class FindAnagrams {
    List<Integer> list;
    public List<Integer> findAnagrams(String s, String p) {
        list = new ArrayList<>();
        int[] count = new int[26];
        for (char c:p.toCharArray()){
            count[c-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if (count[s.charAt(i)-'a']>0){
                traverse(s,count.clone(),i);
            }
        }
        return list;
    }
    private void traverse(String s, int[] count, int index){
        for (int i=index;i<s.length();i++){
            char c = s.charAt(i);
            if (count[c-'a']>0){
                count[c-'a']--;
                if (count[c-'a']==0&&isValid(count)){
                    list.add(index);
                    return;
                }
            }else {
                return;
            }
        }
    }

    private boolean isValid(int[] count){
        for (int n:count){
            if (n!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagrams = findAnagrams.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
}

package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/11
 * Time: 16:00
 * Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            List<Character> characters = new ArrayList<>();
            for (int j=i;j<chars.length;j++){
                if (characters.contains(chars[j])){
                    max = Math.max(max,characters.size());
                    break;
                }else {
                    characters.add(chars[j]);
                }
            }
            max = Math.max(max,characters.size());
        }
        return max;
    }

    public static void main(String[] args) {
        int pwwkew = lengthOfLongestSubstring(" ");
    }
}

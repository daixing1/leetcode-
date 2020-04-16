package MainFunction;

import java.util.ArrayList;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/3/4
 * Time: 23:51
 * Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *              并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
//        Map<Character, Integer>
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Character> hasRemove = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            if (!hasRemove.contains(chars[i])){
                if (characters.contains(chars[i])){
                    characters.remove((Object)chars[i]);
                    hasRemove.add(chars[i]);
                }else {
                    characters.add(chars[i]);
                }
            }
        }
        return str.indexOf(characters.get(0));
    }

    public static void main(String[] args) {
        int google = firstNotRepeatingChar("googgle");
        System.out.println();
    }
}

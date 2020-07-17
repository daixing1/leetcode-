package MainFunction;

import java.util.HashSet;

/**
 * User: 兴希
 * Date: 2020/6/29
 * Time: 9:51
 * Description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        StringBuilder vowels = new StringBuilder();
        for (Character c:s.toCharArray()){
            if (set.contains(c)){
                vowels.append(c);
            }
        }
        StringBuilder reverse = vowels.reverse();
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        for (int i=0;i<s.length();i++){
            if (set.contains(s.charAt(i))){
                sb.replace(i,i+1,vowels.substring(index,index+1));
                index++;
            }
        }
        return sb.toString();
    }
}

package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 20:48
 * Description: 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *              给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。
 *              返回其中最长的子串的长度。
 */
public class MaxRepOpt1I {
    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character cc:text.toCharArray()){
            map.put(cc,map.getOrDefault(cc,0)+1);
        }
        int pos = 0;
        char c = text.charAt(0);
        int len = 1;
        int maxLen = 0;
        for (int i=1;i<text.length();i++){
            char c1 = text.charAt(i);
            if (c1!=c){
                pos = i+1;
                while (pos<text.length()&&c==text.charAt(pos)){
                    pos++;
                    len++;
                }
                if (len<map.get(c)){
                    len++;
                }
                maxLen = Math.max(maxLen,len);
                c = c1;
                len = 1;
            }else {
                len++;
            }
        }
        if (maxLen==0){
            return len;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxRepOpt1I maxRepOpt1I = new MaxRepOpt1I();
        int len = maxRepOpt1I.maxRepOpt1("abcdef");
        System.out.println(len);
    }
}

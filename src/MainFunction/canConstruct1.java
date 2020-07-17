package MainFunction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/16
 * Time: 10:14
 * Description: 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 *              如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 */
public class canConstruct1 {
    public static boolean canConstruct(String s, int k) {
        if (k>s.length()){
            return false;
        }
        if (k==s.length()){
            return true;
        }
        if (s.length()==0){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        int m = 0;
        int n = 0;
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue()%2==0){
                m++;
            }else {
                n++;
            }
        }
        if (k>=n){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean annabelle = canConstruct("yzyzyzyzyzyzyzy", 2);
        System.out.println(annabelle);
    }
}

package MainFunction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/23
 * Time: 8:40
 * Description: 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        if (s==null||t==null||"".equals(s)||"".equals(t)||s.length()<t.length()){
            return "";
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i=0;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        int i=0;
        int j=t.length()-1;
        String tmp = "";
        while (j<s.length()&&j-i>=t.length()-1){
            if (check(smap,tmap)){
                if (tmp.length()>s.substring(i,j+1).length()||tmp.length()==0){
                    tmp = s.substring(i,j+1);
                    if (tmp.length()==t.length()){
                        return tmp;
                    }
                }
                i++;
                smap.put(s.charAt(i-1),smap.getOrDefault(s.charAt(i-1),0)-1);
            }else {
                j++;
                if (j<s.length()){
                    smap.put(s.charAt(j),smap.getOrDefault(s.charAt(j),0)+1);
                }
            }
        }
        return tmp;
    }

    public static boolean check(Map<Character, Integer> smap , Map<Character, Integer> tmap){
        Iterator<Map.Entry<Character, Integer>> iterator = tmap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (smap.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

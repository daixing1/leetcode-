package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/16
 * Time: 20:58
 * Description: 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *              换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {
    String s;
    boolean b;
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()==0||s2.contains(s1)){
            return true;
        }
        b = false;
        s = s2;
        dfs(s1.toCharArray(),new boolean[s1.length()],new StringBuilder());
        return b;
    }

    private void dfs(char[] chars,boolean[] flag,StringBuilder sb){
        if (sb.length()==chars.length){
            if (s.contains(sb)){
                b = true;
                return;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (b){
                break;
            }
            if (!flag[i]){
                flag[i] = true;
                sb.append(chars[i]);
                dfs(chars,flag,sb);
                sb.deleteCharAt(sb.length()-1);
                flag[i] = false;
            }
        }
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length()==0||s2.contains(s1)){
            return true;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s2.length()-s1.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)){
                HashMap<Character, Integer> tmpMap = new HashMap<>(map);
                int j = i;
                while (j<s2.length()&&tmpMap.containsKey(s2.charAt(j))&&tmpMap.get(s2.charAt(j))>0){
                    tmpMap.put(s2.charAt(j),tmpMap.get(s2.charAt(j))-1);
                    j++;
                }
                if (j-i==s1.length()){
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean b = checkInclusion.checkInclusion1("ab", "eidbaooo");
        System.out.println(b);
    }
}

package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 11:24
 * Description: 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *              若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        if (S.length()<2){
            return S;
        }
        Map<Character, Integer> map = new HashMap<>();
        int[][] pos = new int[26][2];
        for (int i=0;i<26;i++){
            pos[i][1] = i;
        }
        Set<Character> set = new HashSet<>();
        for (Character c:S.toCharArray()){
            pos[c-'a'][0]+=1;
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
                set.remove(c);
            }else {
                set.add(c);
                map.put(c,1);
            }
        }
        Arrays.sort(pos,(o1, o2) -> o2[0]-o1[0]);
        StringBuilder sb = new StringBuilder();
        for (int[] c:pos){
            if (!set.contains((char) (c[1]+'a'))){
                sb.append(String.valueOf((char) (c[1]+'a')).repeat(c[0]));
            }
        }
        dealWith(sb,0,1);
        Iterator<Character> iterator = set.iterator();
        StringBuilder res = new StringBuilder(String.valueOf(sb.charAt(0)));
        for (int i=1;i<sb.length();i++){
            if (sb.charAt(i)==sb.charAt(i-1)){
                if (iterator.hasNext()){
                    Character next = iterator.next();
                    res.append(next);
                    res.append(sb.charAt(i));
                }else {
                    return "";
                }
            }else {
                res.append(sb.charAt(i));
            }
        }
        while (iterator.hasNext()){
            Character next = iterator.next();
            res.append(next);
        }
        return res.toString();

    }

    private void dealWith(StringBuilder sb, int start, int end){
        if (end>=sb.length()){
            return;
        }
        if (sb.charAt(start)==sb.charAt(end)){
            int index = end;
            while (index<sb.length()&&sb.charAt(start)==sb.charAt(index)){
                index++;
            }
            if (index<sb.length()){
                sb.insert(start+1,sb.charAt(index));
                sb.deleteCharAt(index+1);
                start+=2;
                end = index;
                dealWith(sb,start,end);
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ReorganizeString string = new ReorganizeString();
        String aab = string.reorganizeString("baaba");
        System.out.println(aab);
    }
}

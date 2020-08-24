package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/29
 * Time: 20:36
 * Description: 给你一个只包含小写字母的字符串 s ，你需要找到 s 中最多数目的非空子字符串，满足如下条件：
 *              这些字符串之间互不重叠，也就是说对于任意两个子字符串 s[i..j] 和 s[k..l] ，要么 j < k 要么 i > l 。
 *              如果一个子字符串包含字符 char ，那么 s 中所有 char 字符都应该在这个子字符串中。
 *              请你找到满足上述条件的最多子字符串数目。如果有多个解法有相同的子字符串数目，
 *              请返回这些子字符串总长度最小的一个解。可以证明最小总长度解是唯一的。
 *              请注意，你可以以 任意 顺序返回最优解的子字符串。
 */
public class MaxNumOfSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<List<String>> lists = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i=0;i<s.length();i++){
            Map<Character, Integer> tmpmap = new HashMap<>(map);
            StringBuilder sb = new StringBuilder();
            List<Character> chars = new ArrayList<>();
            List<String> strings = new ArrayList<>();
            char c = s.charAt(i);
            if (set.contains(c)){
                continue;
            }
            for (int j=i;j<s.length();j++){
                if (set.contains(s.charAt(j))){
                    tmpmap = new HashMap<>(map);
                    sb = new StringBuilder();
                    chars.clear();
                    if (j<s.length()-1){
                        c = s.charAt(j+1);
                    }
                    continue;
                }
                sb.append(s.charAt(j));
                chars.add(s.charAt(j));
                tmpmap.put(s.charAt(j),tmpmap.get(s.charAt(j))-1);
                if (tmpmap.get(c)==0){
                    boolean flag = true;
                    for (char cc:chars){
                        if (set.contains(cc)){
                            sb = new StringBuilder();
                            flag = false;
                            break;
                        }else if (tmpmap.get(cc)>0){
                            c =cc;
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        strings.add(sb.toString());
                        sb = new StringBuilder();
                        chars.clear();
                        if (j<s.length()-1){
                            c = s.charAt(j+1);
                        }
                    }
                }
            }
            set.add(s.charAt(i));
            lists.add(strings);
        }
        List<List<String>> collect = lists.stream().sorted((o1, o2) -> {
            if (o1.size() == o2.size()) {
                int len1 = o1.stream().mapToInt(o -> o.length()).sum();
                int len2 = o2.stream().mapToInt(o -> o.length()).sum();
                return len1 - len2;
            } else {
                return o2.size() - o1.size();
            }
        }).collect(Collectors.toList());
        return collect.get(0);
    }

    public static void main(String[] args) {
        MaxNumOfSubstrings maxNumOfSubstrings = new MaxNumOfSubstrings();
        List<String> list = maxNumOfSubstrings.maxNumOfSubstrings("bbeadcxede");
        System.out.println(list);
    }
}

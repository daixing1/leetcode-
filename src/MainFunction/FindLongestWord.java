package MainFunction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/28
 * Time: 11:58
 * Description: 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 *              如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        List<String> list = d.stream().sorted((o1, o2) -> {
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else {
                return o2.length()-o1.length();
            }
        }).collect(Collectors.toList());
        for (String s1:list){
            if (s1.length()>s.length()){
                continue;
            }else {
                if (isValid(s,s1)){
                    return s1;
                }
            }
        }
        return "";
    }

    public boolean isValid(String s, String s1){
        int i=0,j=0;
        while (i<s.length()&&j<s1.length()){
            if (s.charAt(i)==s1.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }
        return j==s1.length();
    }
}

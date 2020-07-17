package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/1
 * Time: 15:14
 * Description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        res.add(list);
        boolean flag = true;
        for (int i=1;i<strs.length;i++){
            flag = false;
            for (int j=0;j<res.size();j++){
                if (res.get(j).size()==0){
                    continue;
                }else {
                    String s = res.get(j).get(0);
                    if (isAnagrams(new StringBuilder(s),new StringBuilder(strs[i]))){
                        flag = true;
                        res.get(j).add(strs[i]);
                    }
                }
            }
            if (!flag){
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                res.add(strings);
            }
        }
        return res;
    }

    public boolean isAnagrams(StringBuilder s1,StringBuilder s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        for (int i=0;i<s1.length();i++){
            int i1 = s2.indexOf(String.valueOf(s1.charAt(i)));
            if (i1==-1){
                return false;
            }else {
                s2.deleteCharAt(i1);
            }
        }
        return true;
    }
}

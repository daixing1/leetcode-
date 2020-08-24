package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/9
 * Time: 11:06
 * Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *              给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return res;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        traverse(new StringBuilder(),digits);
        return res;
    }

    private void traverse(StringBuilder s, String digits){
        if ("".equals(digits)){
            res.add(new String(s));
            return;
        }
        String s1 = map.get(Integer.valueOf(digits.substring(0, 1)));
        digits = digits.substring(1);
        for (int i=0;i<s1.length();i++){
            s.append(s1.charAt(i));
            traverse(s,digits);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
        System.out.println(list);
    }
}

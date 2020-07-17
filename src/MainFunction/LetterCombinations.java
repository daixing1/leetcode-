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
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> charList= new ArrayList<>();
        for (int i=0;i<digits.length();i++){
            charList.add(map.get(digits.charAt(i)-'0'));
        }
        return res;
    }

    private void traverse(List<String> stringList, List<Integer> indexs, StringBuilder s, int index){
        if (s.length()==stringList.size()){
            res.add(s.toString());
            s.deleteCharAt(s.length()-1);
        }
        for (int i=indexs.get(index);i<stringList.get(index).length();i++){
            s.append(stringList.get(i).charAt(indexs.get(i)));
            indexs.set(i,indexs.get(i)+1);
            if (indexs.get(i)<stringList.get(i).length()){
                traverse(stringList,indexs,s,index);
            }else {
                traverse(stringList,indexs,s,index);
            }

        }

    }

    public static void main(String[] args) {

    }
}

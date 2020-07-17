package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/1
 * Time: 9:58
 * Description: 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，
 *              如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 */
public class CommonChars {
    public static List<String> commonChars(String[] A) {
        if (A.length==0){
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:A[0].toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> resMap = new HashMap<>();
        for (int i=1;i<A.length;i++){
            Map<Character, Integer> tmpMap = new HashMap<>(map);
            for (Character c:A[i].toCharArray()){
                if (tmpMap.containsKey(c)&&tmpMap.get(c)>0){
                    tmpMap.put(c,tmpMap.get(c)-1);
                }
            }
            for (Character c:map.keySet()){
                if (map.get(c)>=tmpMap.get(c)){
                    if (resMap.containsKey(c)){
                        resMap.put(c,Math.min(resMap.get(c),map.get(c)-tmpMap.get(c)));
                    }else {
                        resMap.put(c,map.get(c)-tmpMap.get(c));
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (Character c:resMap.keySet()){
            Integer integer = resMap.get(c);
            while (integer-->0){
                list.add(String.valueOf(c));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = commonChars(new String[]{"cool","lock","cook"});
        System.out.println(list);
    }
}

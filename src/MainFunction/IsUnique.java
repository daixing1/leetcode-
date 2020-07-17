package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/9
 * Time: 10:53
 * Description: 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<astr.length();i++){
            String s = astr.substring(i, i + 1);
            map.put(s,map.getOrDefault(s,0)+1);
            if (map.getOrDefault(s,0)>1){
                return false;
            }
        }
        return true;
    }
}

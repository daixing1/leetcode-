package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/4/27
 * Time: 11:46
 * Description: 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *              如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a:arr){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        if (set.size()==map.size()){
            return true;
        }else {
            return false;
        }
    }
}

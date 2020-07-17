package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/4/27
 * Time: 11:35
 * Description: 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *              给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *              如果数组中存在多个幸运数，只需返回 最大 的那个。
 *              如果数组中不含幸运数，则返回 -1 。
 */
public class FindLucky {
    public int findLucky(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int a:arr){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        map.forEach((k,v)->{
            if (k==v){
                res.add(k);
            }
        });
        if (res.size()==0){
            return -1;
        }
        if (res.size()==1){
            return res.get(0);
        }
        return res.stream().max(Comparator.naturalOrder()).get();
    }
}

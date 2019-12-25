package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2019/12/25
 * Time: 13:09
 * Description: 给定一个整数数组，判断是否存在重复元素。
 *              如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                return true;
            }else {
                map.put(n,1);
            }
        }
        return false;

    }
}

package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/17
 * Time: 11:33
 * Description: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 *              使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])&&(i-map.get(nums[i])<=k)){
                return true;
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}

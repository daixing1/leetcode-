package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/25
 * Time: 11:15
 * Description: 找出数组中重复的数字。
 *              在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 *              但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                return n;
            }
            map.put(n,1);
        }
        return 0;
    }
}

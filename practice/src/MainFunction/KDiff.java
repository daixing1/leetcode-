package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 19:40
 * Description: 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 *              这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，
 *              且两数之差的绝对值是 k.

 */
public class KDiff {

    public int findPairs(int[] nums, int k) {
        int count = 0;
        List<Integer> sum = new ArrayList<>();
        for (int i = 0;i<nums.length-1;i++){
            for (int j = i+1;j<nums.length;j++){
                if (Math.abs(nums[i]-nums[j])==k && !sum.contains(nums[i]+nums[j])){
                    sum.add(nums[i]+nums[j]);
                    count++;
                }
            }
        }
        return count;
    }
}

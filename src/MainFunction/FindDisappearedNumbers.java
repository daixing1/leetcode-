package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/2/22
 * Time: 13:23
 * Description: 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，
 *              另一些只出现一次。
 *              找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *              您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i=0;i<nums.length;i++){
            if (!list.contains(i+1)) {
                list.add(i+1);
            }
        }
        return list.subList(nums.length,list.size());
    }
}

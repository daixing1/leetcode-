package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/24
 * Time: 10:00
 * Description: 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<=nums.length;i++){
            list.add(i);
        }
        for (int i=0;i<nums.length;i++){
            list.remove((Object)nums[i]);
        }
        return list.get(0);
    }
}

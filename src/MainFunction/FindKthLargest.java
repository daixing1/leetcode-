package MainFunction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 20:42
 * Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 *              而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2)->o2-o1).collect(Collectors.toList());
        return list.get(k-1);
    }
}

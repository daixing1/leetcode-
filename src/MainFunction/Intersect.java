package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/24
 * Time: 16:16
 * Description: 给定两个数组，编写一个函数来计算它们的交集
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> collect = Arrays.stream(nums2).boxed().collect(Collectors.toList());
//        collect.remove((Object)2);
        for (int n:nums1){
            if (collect.contains(n)){
                list.add(n);
                collect.remove((Object)n);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] intersect1 = intersect.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println();
    }
}

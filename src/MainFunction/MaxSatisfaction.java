package MainFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/28
 * Time: 11:35
 * Description: 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 *              一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，
 *              也就是 time[i]*satisfaction[i] 。
 *              请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 *              你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和
 */
public class MaxSatisfaction {
    public static int maxSatisfaction(int[] satisfaction) {
        int max = Arrays.stream(satisfaction).boxed().max(Comparator.comparingInt(o -> o)).get();
        List<Integer> collect = Arrays.stream(satisfaction).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        }).collect(Collectors.toList());
        List<Integer> list = collect.subList(0, collect.indexOf(max)+1);
        Collections.sort(list, Comparator.comparingInt(o -> o));
        int res = 0;
        for (int i=0;i<list.size();i++){
            res+=list.get(i)*(i+1);
        }
        return Math.max(0,res);
    }

    public static void main(String[] args) {
        int i = maxSatisfaction(new int[]{2,-2,-3,1});
        System.out.println(i);
    }
}

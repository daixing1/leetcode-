package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/30
 * Time: 8:50
 * Description: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new boolean[nums.length],new ArrayList<>(),0);
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(int[] nums, boolean[] flag, List<Integer> list, int index){
        res.add(new ArrayList<>(list));
        for (int i=index;i<nums.length;i++){
            if (!flag[i]){
                list.add(nums[i]);
                flag[i] = true;
                dfs(nums,flag,list,i);
                list.remove(list.size()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(new int[]{1,2,2});
        System.out.println(lists);
    }
}

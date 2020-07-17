package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 11:19
 * Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *              说明：解集不能包含重复的子集。
 */
public class Subsets1 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,new boolean[nums.length],new ArrayList<>(),0);
        return lists;
    }

    private void dfs(int[] nums, boolean flag[], List<Integer> list, int index){
        lists.add(new ArrayList<>(list));
        for (int i=index;i<nums.length;i++){
//            if (!flag[i]){
//                flag[i] = true;
                list.add(nums[i]);
                dfs(nums,flag,list,i+1);
                list.remove(list.size()-1);
//                flag[i] = false;
//            }
        }
    }

    public static void main(String[] args) {
        Subsets1 subsets1 = new Subsets1();
        List<List<Integer>> subsets = subsets1.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}

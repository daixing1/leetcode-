package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/3
 * Time: 11:06
 * Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的数字可以无限制重复被选取。
 *              说明：
 *                  所有数字（包括 target）都是正整数。
 *                  解集不能包含重复的组合。 
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null||candidates.length==0){
            return res;
        }
        traverse(candidates,target,new ArrayList<>(),0);
        return res.stream().distinct().collect(Collectors.toList());

    }

    public void traverse(int[] candidates,int target, List<Integer> list, int index){
        if (list.stream().mapToInt(o->o).sum()==target){
            res.add(new ArrayList<>(list.stream().sorted().collect(Collectors.toList())));
            return;
        }else if (list.stream().mapToInt(o->o).sum()>target){
            return;
        }

        for (int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            traverse(candidates,target,list,i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6,7}, 7);
        System.out.println(lists);
    }
}

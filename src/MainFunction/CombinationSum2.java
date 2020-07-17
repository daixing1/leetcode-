package MainFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/3
 * Time: 10:28
 * Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的每个数字在每个组合中只能使用一次
 */
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null||candidates.length==0){
            return res;
        }
        traverse(candidates,target,new boolean[candidates.length],new ArrayList<>(),0);
        return res.stream().distinct().collect(Collectors.toList());

    }

    public void traverse(int[] candidates,int target, boolean[] flag, List<Integer> list, int index){
        if (list.stream().mapToInt(o->o).sum()==target){
            res.add(new ArrayList<>(list.stream().sorted().collect(Collectors.toList())));
            return;
        }else if (list.stream().mapToInt(o->o).sum()>target){
            return;
        }

        for (int i=index;i<candidates.length;i++){
            if (!flag[i]){
                list.add(candidates[i]);
                flag[i] = true;
                traverse(candidates,target,flag,list,i+1);
                list.remove(list.size()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(new int[]{4,4,2,1,4,2,2,1,3}, 6);
        System.out.println(lists);
    }
}

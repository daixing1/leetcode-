package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/16
 * Time: 10:25
 * Description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1] = i;
        }
        dfs(nums,new boolean[n],new ArrayList<>(),0,k);
        return res;
    }

    public void dfs(int[] nums, boolean[] flag, List<Integer> list, int pos,int k){
        if (list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos;i<nums.length;i++){
            if (!flag[i]){
                list.add(nums[i]);
                flag[i] = true;
                dfs(nums,flag,list,i,k);
                list.remove(list.size()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 3);
        System.out.println(combine1);
    }
}

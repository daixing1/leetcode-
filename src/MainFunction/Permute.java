package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/4/25
 * Time: 10:27
 * Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(),res,used,nums);
        return res;
    }

    public static void dfs(List<Integer> output,List<List<Integer>> res,boolean[] used,int[] nums){
        if (output.size()==nums.length){
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!used[i]) {
                output.add(nums[i]);
                used[i] = true;
                dfs(output, res, used, nums);
                used[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}

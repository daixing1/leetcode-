package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/2
 * Time: 9:31
 * Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums,new boolean[nums.length],new ArrayList<>());
        return res.stream().distinct().collect(Collectors.toList());
    }

    public void permute(int[] nums, boolean[] flag, List<Integer> list){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!flag[i]){
                if (i>0&&nums[i]==nums[i-1]&&!flag[i-1]){
                    continue;
                }
                list.add(nums[i]);
                flag[i] = true;
                permute(nums,flag,list);
                list.remove(list.size()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(new int[]{2, 2, 1, 1});
        System.out.println();
    }
}

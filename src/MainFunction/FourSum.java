package MainFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/8/13
 * Time: 20:58
 * Description: 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素
 *              a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class FourSum {
    List<List<Integer>> lists = new ArrayList<>();
    int tar = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        tar = target;
        getResult(nums,new boolean[nums.length],0,new ArrayList<>(),0);
        return lists.stream().distinct().collect(Collectors.toList());
    }

    private void getResult(int[] nums, boolean[] flag, int index, List<Integer> list, int sum){
        if (list.size()==4){
            if (sum==tar){
                List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
                lists.add(collect);
            }
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (!flag[i]){
                flag[i] = true;
                list.add(nums[i]);
                sum+=nums[i];
                getResult(nums,flag,i+1,list,sum);
                list.remove(list.size()-1);
                sum-=nums[i];
                flag[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}

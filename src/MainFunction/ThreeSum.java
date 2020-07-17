package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/31
 * Time: 12:01
 * Description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *              请你找出所有满足条件且不重复的三元组。
 *              注意：答案中不可以包含重复的三元组
 */
public class ThreeSum {
    Integer min = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        if (nums==null||nums.length<3){
            return 0;
        }
        min = nums[0]+nums[1]+nums[2];
        traverse(new boolean[nums.length],nums,new ArrayList<>(),3, target);
        return min;
    }

    public void traverse(boolean[] flag, int[] nums, List<Integer> list, Integer size, Integer target){
        if (list.size()==size){
            if (Math.abs(list.stream().mapToInt(o->o).sum()-target)<Math.abs(min-target)){
                min = list.stream().mapToInt(o->o).sum();
            }
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!flag[i]){
                list.add(nums[i]);
                flag[i] = true;
                traverse(flag,nums,list,size,target);
                list.remove((Object)nums[i]);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        for (int i=0;i<nums.length-2;i++){
            if (i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while (left<right&&left<nums.length&&right>=0){
                if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if (nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    right--;
                    left++;
                }
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

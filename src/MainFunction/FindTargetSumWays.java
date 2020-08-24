package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 9:50
 * Description: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 *              对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *              返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class FindTargetSumWays {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,0,0);
        return count;
    }

    private void dfs(int[] nums, int sum, int index, int n){
        if (index==nums.length&&sum==0){
            count++;
            return;
        }
        if (nums.length==index&sum!=0){
            return;
        }
        dfs(nums,sum-nums[index],index+1,n+1);
        dfs(nums,sum+nums[index],index+1,n+1);
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int targetSumWays = findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}

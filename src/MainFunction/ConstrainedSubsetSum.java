package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/28
 * Time: 11:06
 * Description: 给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，
 *              子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，
 *              它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
 *              数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布
 */
public class ConstrainedSubsetSum {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int j = 0;
        for (int i=1;i<nums.length;i++){
            if (i-j<=k){
                if (dp[i-1]+nums[i]>=dp[i-1]){
                    dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
                    j = i;
                }else {
                    dp[i] = dp[i-1];
                }
            }else {
                if (nums[i]>=dp[i-1]){
                    dp[i] = nums[i];
                    j = i;
                }else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int i = constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2);
        System.out.println(i);
    }
}

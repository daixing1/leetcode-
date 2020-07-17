package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/18
 * Time: 8:33
 * Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 *              并返回该子数组所对应的乘积
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        if (nums.length==0){
            return 0;
        }
        int max = nums[0];
        for (int i=0;i<nums.length;i++){
            int sum = 1;
            for (int j=i;j<nums.length;j++){
//                if (i==0||j==0){
//                    dp[i][j] = i==0?nums[j]:nums[i];
//                }
                sum*=nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}

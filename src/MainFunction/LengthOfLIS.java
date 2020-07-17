package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 10:22
 * Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
